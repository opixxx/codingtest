package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5557 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long[][] dp = new long[n][21];

		dp[0][arr[0]] = 1;

		int a= 0;
		int b = 0;

		for (int i = 1; i < n - 1; i++) {
			for (int j = 0; j <= 20; j++) {
				if (dp[i - 1][j] != 0) {
					a = j + arr[i];
					b = j - arr[i];
				}

				if (a >= 0 && a <= 20) {
					dp[i][a] += dp[i - 1][j];
				}
				if (b >= 0 && b <= 20) {
					dp[i][b] += dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[n - 2][arr[n - 1]]);
	}
}
