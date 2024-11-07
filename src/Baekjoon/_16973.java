package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16973 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] ch;
    static int n, m, h, w, targetX, targetY;
    static Queue<Node> q = new ArrayDeque<>();
    static int[][] map;
    static int[][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sum = new int[n + 1][m + 1];
        map = new int[n + 1][m + 1];
        ch = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + map[i][j];
            }
        }

        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        targetX = Integer.parseInt(st.nextToken());
        targetY = Integer.parseInt(st.nextToken());

        Node start = new Node(startX, startY, 0);
        q.offer(start);
        ch[startX][startY] = true;
        System.out.println(bfs());


    }

    private static int bfs() {

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == targetX && cur.y == targetY) {
                return cur.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 1 && nx + h - 1 <= n && ny >= 1 && ny + w - 1 <= m && !ch[nx][ny]) {
                    if (check(nx, ny)) {
                        ch[nx][ny] = true;
                        q.offer(new Node(nx, ny, cur.count + 1));
                    }
                }
            }
        }
        return -1;
    }

    private static boolean check(int nx, int ny) {
        int x2 = nx + h - 1;
        int y2 = ny + w - 1;

        int count = sum[x2][y2] - sum[nx - 1][y2] - sum[x2][ny - 1] + sum[nx - 1][ny - 1];
        return count == 0;
    }

    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
