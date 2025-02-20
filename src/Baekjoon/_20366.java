package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _20366 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int snow1 = 0;
		int snow2 = 0;
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				snow1 = arr[i] + arr[j];

				int lt = 0;
				int rt = n - 1;
				while (lt < rt) {
					if (lt == i || lt == j) {
						lt++;
						continue;
					}
					if (rt == i || rt == j) {
						rt--;
						continue;
					}

					snow2 = arr[lt] + arr[rt];
					answer = Math.min(answer, Math.abs(snow1 - snow2));

					if (snow1 > snow2) {
						lt++;
					} else {
						rt--;
					}
				}
			}
		}

		System.out.println(answer);
	}
}
