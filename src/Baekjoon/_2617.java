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

		int[][] floyd = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					floyd[i][j] = 0;
				} else {
					floyd[i][j] = MAX;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			floyd[a][b] = 1;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
				}
			}
		}


		getAnswer(n, floyd);
		System.out.println(set.size());
	}

	private static void getAnswer(int n, int[][] floyd) {
		for (int i = 1; i <= n; i++) {
			int count1 = 0;
			int count2 = 0;
			for (int j = 1; j <= n; j++) {
				if (floyd[i][j] > 0 && floyd[i][j] < MAX) {
					count1++;
				}

				if (floyd[j][i] > 0 && floyd[j][i] < MAX) {
					count2++;
				}
			}
			if (count1 > n / 2) {
				set.add(i);
			}
			if (count2 > n / 2) {
				set.add(i);
			}
		}
	}
}
