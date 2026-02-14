package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1654 {
	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		arr = new long[k];
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		long right = arr[k - 1];


		System.out.println(binarySearch(right, n));
	}

	static long binarySearch(long right, long target) {
		long l = 1;
		long r = right + 1;
		while (l < r) {
			long mid = (l + r) >>> 1;
			long value = getValue(mid);

			if (value < target) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l - 1;
	}

	static long getValue(long mid) {
		long output = 0;
		for (int i = 0; i < arr.length; i++) {
			output += arr[i] / mid;
		}
		return output;
	}

}
