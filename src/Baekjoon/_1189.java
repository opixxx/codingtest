package Baekjoon;

import java.util.Scanner;

public class _1189 {
    static int r, c, k, count = 0;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        k = sc.nextInt();

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String input = sc.next();
            for (int j = 0; j < c; j++) {
                char d = input.charAt(j);
                map[i][j] = d;
                if (d == 'T') {
                    visited[i][j] = true;
                }
            }
        }
        visited[r - 1][0] = true;

        dfs(r - 1, 0, 1);

        System.out.println(count);
    }
    private static void dfs(int x, int y, int dis) {
        if (x == 0 && y == c - 1) {
            if (dis == k) {
                count++;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, dis + 1);
                visited[nx][ny] = false;
            }
        }
    }
}
