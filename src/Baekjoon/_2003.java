package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int l = 0, r = 0;
		long sum = 0;
		int answer = 0;

		while (true) {
			if (sum >= m) {
				if (sum == m) {
					answer++;
				}
				sum -= arr[l++];
			} else {
				if (r == n) {
					break;
				}
				sum += arr[r++];
			}
		}
		System.out.println(answer);
	}
}
