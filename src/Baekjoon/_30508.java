package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _30508 {
    static Queue<Node> q = new ArrayDeque<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m;
    static int[][] ch;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        ch = new int[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            q.offer(new Node(a, b));
            ch[a][b] = 1;
        }

        bfs();
        int count = 0;
        for (int i = 0; i <= n - h; i++) {
            for (int j = 0; j <= m - w; j++) {
                boolean flag = true;
                for (int x = 0; x < h; x++) {
                    for (int y = 0; y < w; y++) {
                        if (ch[i + x][j + y] == 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) {
                        break;
                    }
                }
                if (flag) count++;
            }
        }

        System.out.println(count);

    }

    private static void bfs() {

        while (!q.isEmpty()) {

            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && ch[nx][ny] == 0) {
                    if (arr[cur.x][cur.y] <= arr[nx][ny]) {
                        ch[nx][ny] = 1;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
