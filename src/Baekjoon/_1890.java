package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1890 {
    static int[][] game;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        game = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][] dp = new long[n][n];

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1) {
                    continue;
                }
                int move = game[i][j];
                if (j + move < n) {
                    dp[i][j + move] += dp[i][j];
                }

                if (i + move < n) {
                    dp[i + move][j] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }

}
