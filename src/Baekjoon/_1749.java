package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1749 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] ps = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				int v = Integer.parseInt(st.nextToken());
				ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + v;
			}
		}

		int ans = Integer.MIN_VALUE;

		for (int x1 = 1; x1 <= n; x1++) {
			for (int y1 = 1; y1 <= m; y1++) {
				for (int x2 = x1; x2 <= n; x2++) {
					for (int y2 = y1; y2 <= m; y2++) {
						int sum = ps[x2][y2] - ps[x1 - 1][y2] - ps[x2][y1 - 1] + ps[x1 - 1][y1 - 1];
						if (sum > ans) ans = sum;
					}
				}
			}
		}
		System.out.println(ans);

	}
}
