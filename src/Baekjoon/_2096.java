package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2096 {
    static int[][] cost;
    static int[][] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        cost = new int[n][3];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = maxDP();
        int min = minDP();

        System.out.println(max + " " + min);
    }

    private static int minDP() {
        resetDP();
        for (int i = 1; i < n; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = cost[i][1] + Math.min(Math.min(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);

    }

    private static int maxDP() {
        resetDP();
        for (int i = 1; i < n; i++) {
            dp[i][0] = cost[i][0] + Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = cost[i][1] + Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
            dp[i][2] = cost[i][2] + Math.max(dp[i - 1][1], dp[i - 1][2]);
        }

        return Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);

    }

    private static void resetDP() {
        dp = new int[n][3];

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];
    }
}
