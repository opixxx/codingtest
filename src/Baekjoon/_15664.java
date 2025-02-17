package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15664 {
	static int n, m;
	static int[] arr, answer;
	static boolean[] ch;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		answer = new int[m];
		ch = new boolean[n];



		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		dfs(0,0);
		System.out.println(sb);

	}

	static void dfs(int start, int level) {
		if (level == m) {
			for (int i = 0; i < m; i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		int lastUsed = -1;
		for (int i = start; i < n; i++) {
			if (lastUsed != arr[i] && !ch[i]) {
				lastUsed = arr[i];
				ch[i] = true;
				answer[level] = arr[i];
				dfs(i + 1, level + 1);
				ch[i] = false;
			}
		}
	}
}
