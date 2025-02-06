package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14889v2 {
	static int[] ch;
	static int n;
	static int[][] arr;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		ch = new int[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);

		System.out.println(answer);

	}

	private static void dfs(int idx, int cnt) {
		if (n / 2 == cnt) {
			calc();
			return;
		}
		for (int i = idx; i < n; i++) {
			if (ch[i] == 0) {
				ch[i] = 1;
				dfs(i + 1, cnt + 1);
				ch[i] = 0;
			}
		}
	}

	private static void calc() {
		int start = 0;
		int link = 0;

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (ch[i] == 1 && ch[j] == 1) {
					start += arr[i][j] + arr[j][i];
				} else if (ch[i] == 0 && ch[j] == 0) {
					link += arr[i][j] + arr[j][i];
				}
			}
		}
		int result = Math.abs(start - link);
		answer = Math.min(answer, result);
	}
}
