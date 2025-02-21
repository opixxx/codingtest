package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _2617 {
	static final int MAX = 987654321;
	static Set<Integer> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] floyd1 = new int[n + 1][n + 1];
		int[][] floyd2 = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					floyd1[i][j] = 0;
					floyd2[i][j] = 0;
				} else {
					floyd1[i][j] = MAX;
					floyd2[i][j] = MAX;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			floyd1[a][b] = 1;
			floyd2[b][a] = 1;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					floyd1[i][j] = Math.min(floyd1[i][j], floyd1[i][k] + floyd1[k][j]);
					floyd2[i][j] = Math.min(floyd2[i][j], floyd2[i][k] + floyd2[k][j]);
				}
			}
		}


		getAnswer(n, floyd1);
		getAnswer(n, floyd2);
		System.out.println(set.size());
	}

	private static void getAnswer(int n, int[][] floyd1) {
		for (int i = 1; i <= n; i++) {
			int count = 0;
			for (int j = 1; j <= n; j++) {
				if (floyd1[i][j] > 0 && floyd1[i][j] < MAX) {
					count++;
				}
			}
			if (count > n / 2) {
				set.add(i);
			}
		}
	}
}
