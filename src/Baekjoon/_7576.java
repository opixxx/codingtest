package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7576 {
    static int[][] tomato, tmp;
    static Queue<Tomato> q = new ArrayDeque<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());


        tomato = new int[n][m];
        tmp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    q.offer(new Tomato(i, j));
                }
            }
        }

        bfs();

        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomato[i][j] == 0) {
                    flag = false;
                }
            }
        }
        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, tmp[i][j]);
                }
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);

        }
    }

    static void bfs() {

        while (!q.isEmpty()) {
            Tomato cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && tomato[nx][ny] == 0) {
                    tomato[nx][ny] = 1;
                    q.offer(new Tomato(nx, ny));
                    tmp[nx][ny] = tmp[cur.x][cur.y] + 1;
                }
            }
        }
    }

    static class Tomato {
        int x;
        int y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
