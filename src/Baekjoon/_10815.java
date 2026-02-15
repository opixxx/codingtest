package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10815 {
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
		while (m-- > 0) {
			int target = Integer.parseInt(st.nextToken());

			if (binarySearch(arr, target)) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}
		}
		System.out.println(sb);

	}

	static boolean binarySearch(int[] arr, int target) {
		int l = 0;
		int r = arr.length;

		while (l < r) {
			int mid = (l + r) >>> 1;
			if (arr[mid] >= target) r = mid;
			else l = mid + 1;
		}
		return l < arr.length && arr[l] == target;
	}
}
