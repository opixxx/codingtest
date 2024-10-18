package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7562 {
    static int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};
    static boolean[][] ch;
    static int[][] arr;
    static int n;
    static Queue<Node> q;
    static StringBuilder sb = new StringBuilder();
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            answer = Integer.MAX_VALUE;
            q = new ArrayDeque<>();

            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            ch = new boolean[n][n];

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            q.offer(new Node(startX, startY, 0));
            bfs(targetX, targetY);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);

    }

    private static void bfs(int targetX, int targetY) {
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == targetX && cur.y == targetY) {
                answer = Math.min(answer, cur.cnt);
            }
            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !ch[nx][ny]) {
                    ch[nx][ny] = true;
                    q.offer(new Node(nx, ny, cur.cnt + 1));
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
