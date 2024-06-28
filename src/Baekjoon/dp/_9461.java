package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int a = Integer.parseInt(br.readLine());
            long answer = solution(a);
            System.out.println(answer);

        }
    }

    static long solution(int a) {
        long[] dp = new long[101];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dp[6] = 3;

        for (int i = 7; i <= a; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        return dp[a];
    }
}
