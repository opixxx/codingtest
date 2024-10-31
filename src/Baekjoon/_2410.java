package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2410 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int mod = 1_000_000_000;
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 2] % mod  + dp[i / 2] % mod) % mod;
        }

        System.out.println(dp[n]);

    }
}
