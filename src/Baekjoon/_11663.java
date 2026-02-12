package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11663 {
	static final int COORDINATE = 1_000_000_000;
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

		Arrays.sort(arr);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int left = lowerBound(arr, a);
			int right = upperBound(arr, b);
			sb.append(right - left).append("\n");
		}
		System.out.println(sb);

	}
	static int lowerBound(int[] arr, int a) {
		int l = 0;
		int r = arr.length;
		while (l < r) {
			int mid = (l + r) >>> 1;
			if (arr[mid] >= a) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

	static int upperBound(int[] arr, int b) {
		int l = 0;
		int r = arr.length;
		while (l < r) {
			int mid = (l + r) >>> 1;
			if (arr[mid] > b) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

}
