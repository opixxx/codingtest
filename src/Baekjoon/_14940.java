package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14940 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m, targetX, targetY;
    static int[][] board, answer, ch;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        answer = new int[n][m];

        targetX = 0;
        targetY = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    targetX = i;
                    targetY = j;
                }
                if (board[i][j] == 0) {
                    answer[i][j] = 0;
                } else {
                    answer[i][j] = -1;
                }
            }
        }

        bfs(targetX, targetY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void bfs(int x, int y) {
        q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        answer[x][y] = 0;


        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int curX = poll[0];
            int curY = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] != 0 && answer[nx][ny] == -1) {
                    answer[nx][ny] = answer[curX][curY] + 1;
                    q.offer(new int[]{nx, ny});

                }
            }
        }
    }
}
