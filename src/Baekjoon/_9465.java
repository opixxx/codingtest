package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] cost = new int[2][n];
            int[][] dp = new int[2][n];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    cost[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = cost[0][0];
            dp[1][0] = cost[1][0];


            for (int j = 1; j < n; j++) {
                if (j == 1) {
                    dp[0][j] = cost[0][1] + dp[1][0];
                    dp[1][j] = cost[1][1] + dp[0][0];
                    continue;
                }
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + cost[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + cost[1][j];
            }

            System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
        }

    }
}
