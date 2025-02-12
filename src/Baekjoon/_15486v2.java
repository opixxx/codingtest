package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15486v2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 2];
		int[] day = new int[n + 2];
		int[] pay = new int[n + 2];

		for (int i = 1; i <=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day[i] = Integer.parseInt(st.nextToken());
			pay[i] = Integer.parseInt(st.nextToken());

		}
		int max = 0;
		for (int i = 1; i <= n + 1; i++) {

			if (max < dp[i]) {
				max = dp[i];
			}
			int nextDay = day[i] + i;

			if (nextDay <= n + 1) {
				dp[nextDay] = Math.max(dp[nextDay], max + pay[i]);
			}
		}

		System.out.println(max);

	}
}
