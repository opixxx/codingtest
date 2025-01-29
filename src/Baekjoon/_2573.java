package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2573 {
    static Queue<Pair> q;
    static Queue<Pair> q1;
    static int[][] board, tmp, ch;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        tmp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        int year = 0;
        int cnt = 0;
        while ((cnt = getIce()) < 2) {
            if (cnt == 0) {
                year = 0;
                break;
            }

            bfs();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board[i][j] = tmp[i][j];
                }
            }

            year++;
        }
        System.out.print(year);
    }

    static void bfs() {
        tmp = new int[n][m];
        q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] > 0) {
                    q.offer(new Pair(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            var cur = q.poll();

            int count = 0;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    count++;
                }
            }
            int value = board[cur.x][cur.y] - count;

            tmp[cur.x][cur.y] = value < 0 ? 0 : value;
        }
    }

    static int getIce() {
        ch = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] > 0 && ch[i][j] == 0) {
                    count++;
                    isAnswer(i, j);
                }
            }
        }
        return count;
    }

    static void isAnswer(int x, int y) {
        q1 = new LinkedList<>();
        q1.offer(new Pair(x, y));
        ch[x][y] = 1;
        while (!q1.isEmpty()) {
            var cur = q1.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] > 0 && ch[nx][ny] == 0) {
                    q1.offer(new Pair(nx, ny));
                    ch[nx][ny] = 1;
                }
            }
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
