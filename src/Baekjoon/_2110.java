package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2110 {
	static int[] arr;
	static int n, c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		int lt = 0;
		int rt = 1000000000;

		int answer = 0;

		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if (isCan(mid)) {
				answer = mid;
				lt = mid + 1;
			} else {
				rt = mid - 1;
			}
		}

		System.out.println(answer);

	}

	static boolean isCan(int dis) {
		int cnt = 1;
		int last = arr[0];

		for (int i = 1; i < n; i++) {
			if (arr[i] - last < dis) {
				continue;
			}
			last = arr[i];
			cnt++;
		}

		return cnt >= c;
	}


}
