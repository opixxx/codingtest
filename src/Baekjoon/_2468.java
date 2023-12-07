package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2468 {
    static int[][] map, check;
    static int n, count;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void DFS(int height, int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        while (!q.isEmpty()) {
            Point tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] > height && check[nx][ny] == 0) {
                    check[nx][ny] = 1;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new int[n][n];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                max = Math.max(map[i][j], max);
            }
        }
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < max; i++) {
            count = 0;
            check = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] > i && check[j][k] == 0) {
                        count++;
                        DFS(i,j,k);
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }

}
