package Programmers;

public class 선_모양_타일링 {
	static int MOD = 10007;
	public int solution(int n, int[] tops) {
		int answer = 0;

		int t = 2 * n + 1;

		int[] dp = new int[t + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i<= t; i++) {
			if(i % 2 == 0 && tops[(i - 2) / 2] == 1) {
				dp[i] = (dp[i-1] * 2 + dp[i-2]) % MOD;
			} else {
				dp[i] = (dp[i-1] + dp[i-2]) % MOD;
			}
		}

		answer = dp[t];

		return answer;
	}
}
