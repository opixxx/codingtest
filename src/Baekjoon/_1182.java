package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1182 {
	static int n, s;
	static int count = 0;
	static int[] arr;
	static int[] ch;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		arr = new int[n];
		ch = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0, 0);

		System.out.println(count);

	}

	static void dfs(int l, int sum, int selected) {
		if (l == n) {
			if (sum == s && selected > 0) {
				count++;
			}
			return;

		}
		dfs(l + 1, sum + arr[l], selected + 1);
		dfs(l + 1, sum, selected);
	}
}
