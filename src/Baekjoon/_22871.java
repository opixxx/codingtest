package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _22871 {
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        long[] dp = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            dp[i] = Long.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                dp[i] = Math.min(dp[i], Math.max(power(i, j), dp[j]));
            }
        }

        System.out.println(dp[n - 1]);

    }

    static long power(int j, int i) {
        return (long) (j - i) * (1 + Math.abs(arr[i] - arr[j]));
    }
}
