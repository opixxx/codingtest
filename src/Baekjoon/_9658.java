package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9658 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];

		dp[1] = 1; //창영 승
		dp[2] = 0; //상근 승
		dp[3] = 1;

		for (int i = 4; i <= n; i++) {
			if (dp[i - 1] + dp[i - 3] + dp[i - 4] > 0) {
				dp[i] = 0;
			} else {
				dp[i] = 1;
			}
		}

		if (dp[n] == 0) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
	}
}
