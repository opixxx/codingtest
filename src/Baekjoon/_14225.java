package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14225 {
	static int n;
	static int[] arr;
	static int[] tmp = new int[20000001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);

		int answer = 0;
		for (int i = 0; i < 2000001; i++) {
			if (tmp[i] != 1) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}

	static void dfs(int index, int sum) {
		if (index == n) {
			tmp[sum] = 1;
			return;
		}

		dfs(index + 1, sum + arr[index]);
		dfs(index + 1, sum);
	}
}
