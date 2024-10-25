package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/*
* n,m 잘보자,,, 뭐가 가로인지 세로인지,,, 뻘짓했네
* */
public class _1303 {
    static Queue<Node> q;
    static int W, B;
    static int n, m;
    static char[][] war;
    static boolean[][] ch;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        war = new char[m][n];
        ch = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                war[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!ch[i][j]) {
                    ch[i][j] = true;
                    bfs(i, j, war[i][j]);
                }
            }
        }

        System.out.println(W + " "+ B);
    }

    private static void bfs(int x, int y, char c) {
        q = new ArrayDeque<>();
        q.offer(new Node(x, y));
        int count = 1;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !ch[nx][ny] && war[nx][ny] == c) {
                    ch[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                    count++;

                }
            }
        }

        if (c == 'W') {
            W += (int) Math.pow(count, 2);
        } else {
            B += (int) Math.pow(count, 2);
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
