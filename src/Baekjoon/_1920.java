package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());
			if (binarySearch(arr, target)) {
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}
		}
		System.out.println(sb);

	}

	static boolean binarySearch(int[] arr, int target) {

		int left = 0;
		int right = arr.length;
		while (left < right) {
			int mid = (left + right) >>> 1;
			if (arr[mid] >= target) right = mid;
			else left = mid + 1;
		}
		return left < arr.length && arr[left] == target;
	}
}
