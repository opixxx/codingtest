package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _21736 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] board;
    static int n, m;
    static Queue<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i] = input.toCharArray();
            }
        }
        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }


        int answer = bfs(x, y);
        if (answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
        }
    }

    private static int bfs(int x, int y) {
        q.offer(new int[]{x, y});
        int count = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int curX = poll[0];
            int curY = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] != 'X') {
                    if (board[nx][ny] == 'P') {
                        count++;
                    }
                    board[nx][ny] = 'X';
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return count;
    }
}
