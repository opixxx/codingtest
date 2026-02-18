package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13422 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[] arr = new int[n];

			int total = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				total += arr[j];
			}

			if (m == n) {
				sb.append(total < k ? 1 : 0).append("\n");
				continue;
			}

			int[] arr1 = new int[n + m - 1];
			for (int j = 0; j < n + m - 1; j++) {
				arr1[j] = arr[j % n];
			}

			long[] prefixSum = new long[n + m];

			for (int j = 1; j < n + m; j++) {
				prefixSum[j] = prefixSum[j - 1] + arr1[j - 1];
			}

			int l = 0;
			int r = m;
			int answer = 0;
			while (r < prefixSum.length) {
				if (prefixSum[r] - prefixSum[l] < k) {
					answer++;
				}
				l++;
				r++;
			}

			sb.append(answer + "\n");

		}
		System.out.println(sb);

	}
}
