package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1106 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];
		int[] dp = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			if (dp[i] == Integer.MAX_VALUE) {
				continue;
			}
			int range = a[i];
			for (int j = i + 1; j <= i + range; j++) {
				if (j < n) {
					dp[j] = Math.min(dp[j], dp[i] + 1);
				}
			}
		}
		System.out.println(dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1]);
	}
}
