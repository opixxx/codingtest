package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int rt = 0;
		int sum = 0;
		int ans = Integer.MAX_VALUE;

		for (int lt = 1; lt <= n; lt++) {
			sum -= arr[lt - 1];

			while (rt + 1 <= n && sum < s) {
				sum += arr[++rt];
			}

			if (sum >= s) {
				ans = Math.min(ans, rt - lt + 1);
			}
		}

		if (ans == Integer.MAX_VALUE) {
			ans = 0;
		}

		System.out.println(ans);

	}
}
