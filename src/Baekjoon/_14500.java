package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14500 {
    static int[][] arr;
    static int[][] ch;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static int m;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        ch = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ch[i][j] = 1;
                dfs(i, j, arr[i][j], 1);
                ch[i][j] = 0;
            }
        }

        System.out.println(answer);

    }

    static void dfs(int row, int col, int sum, int count) {
        if (count == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && ch[nx][ny] == 0) {
                if (count == 2) {
                    ch[nx][ny] = 1;
                    dfs(row, col, sum + arr[nx][ny], count + 1);
                    ch[nx][ny] = 0;
                }

                ch[nx][ny] = 1;
                dfs(nx, ny, sum + arr[nx][ny], count + 1);
                ch[nx][ny] = 0;
            }

        }
    }
}
