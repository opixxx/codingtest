package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21318 {
	static int[] arr;
	static int n;
	static int[] prefixSum;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int q = Integer.parseInt(br.readLine());

		prefixSum = getPrefixSum();

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			sb.append(solution(x, y)).append("\n");
		}
		System.out.println(sb);

	}
	static int[] getPrefixSum() {
		int[] prefixSum = new int[n + 1];

		prefixSum[0] = 0;

		for (int i = 1; i <= n; i++) {
			if (arr[i] < arr[i - 1]) { //실수
				prefixSum[i] = prefixSum[i - 1] + 1;
			} else {
				prefixSum[i] = prefixSum[i - 1];
			}
		}

		return prefixSum;
	}

	static int solution(int x, int y) {
		return prefixSum[y] - prefixSum[x];
	}
}
