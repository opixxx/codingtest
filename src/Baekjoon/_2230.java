package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2230 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int l = 0;
		int r = 0;

		long answer = Long.MAX_VALUE;
		while (l < n && r < n) {
			long diff = (long)arr[r] - arr[l];
			if (diff >= m) {
				answer = Math.min(answer, diff);
				l++;
			} else {
				r++;
			}
			if (l == r) {
				r++;
			}
		}

		System.out.println(answer);
	}
}
