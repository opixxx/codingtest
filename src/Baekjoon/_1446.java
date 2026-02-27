package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1446 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		List<ShortCut> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			if (end <= d) {
				list.add(new ShortCut(start, end, cost));
			}
		}

		int[] dp = new int[d + 1];

		for (int i = 0; i <= d; i++) {
			dp[i] = i;
		}

		for (int i = 0; i <= d; i++) {
			if (i > 0) {
				dp[i] = Math.min(dp[i], dp[i - 1] + 1);
			}
			for (ShortCut s : list) {
				if (s.start == i) {
					dp[s.end] = Math.min(dp[s.end], dp[s.start] + s.cost);
				}
			}
		}

		System.out.println(dp[d]);
	}

	static class ShortCut {
		int start;
		int end;
		int cost;

		public ShortCut(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
}
