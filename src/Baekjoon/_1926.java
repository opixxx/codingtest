package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1926 {
    static int count = 0;
    static int[][] arr;
    static boolean[][] ch;
    static int n, m;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        ch = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !ch[i][j]) {
                    count++;
                    bfs(i, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (count == 0) {
            max = 0;
        }
        sb.append(count).append("\n").append(max);
        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(x, y));
        int tmp = 1;
        ch[x][y] = true;

        while (!q.isEmpty()) {
            var cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !ch[nx][ny] && arr[nx][ny] == 1) {
                    tmp++;
                    ch[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
            }
        }
        max = Math.max(max, tmp);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
