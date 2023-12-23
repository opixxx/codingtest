package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class PointAndCount {
    int x,y, count;

    public PointAndCount(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

public class _2589 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    visited = new boolean[n][m];
                    int distance = BFS(i, j);
                    answer = Math.max(answer, distance);
                }
            }
        }
        System.out.println(answer);

    }

    private static int BFS(int x, int y) {
        visited[x][y] = true;
        Queue<PointAndCount> q = new LinkedList<>();

        int distance = 0;
        q.offer(new PointAndCount(x, y, 0));

        while (!q.isEmpty()) {
            PointAndCount cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    q.add(new PointAndCount(nx, ny, cur.count + 1));
                    distance = Math.max(distance, cur.count + 1);
                }
            }
        }
        return distance;
    }
}
