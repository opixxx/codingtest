package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _15558 {
    static Queue<Node> q = new ArrayDeque<>();
    static int[][] arr;
    static int[][] ch;
    static int n, k;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + k][2];
        ch = new int[n + k][2];

        for (int i = 0; i < 2; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                int a = input.charAt(j) - '0';
                arr[j][i] = a;
            }
        }

        for (int i = n; i < n + k; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = 1;
            }
        }

        System.out.println(bfs() ? 1 : 0);

    }

    private static boolean bfs() {
        int[] dx = {1, -1, k};
        q.offer(new Node(0, 0, 0));
        ch[0][0] = 1;

        while (!q.isEmpty()) {

            Node cur = q.poll();
            if (cur.x >= n) {
                return true;
            }
            if (cur.time < n) {
                arr[cur.time][0] = 0;
                arr[cur.time][1] = 0;
            }
            for (int i = 0; i < 3; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y;

                if (i == 2) {
                    ny = 1 - cur.y;
                }

                if (nx >= 0 && nx < n+k && ny >= 0 && ny < 2 && arr[nx][ny] == 1 && ch[nx][ny] == 0) {
                    q.offer(new Node(nx, ny, cur.time + 1));
                    ch[nx][ny] = 1;
                }
            }
        }
        return false;

    }

    static class Node {
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
