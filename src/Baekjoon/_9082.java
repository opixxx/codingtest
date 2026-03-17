package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9082 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());

			int[] arr1 = new int[n];
			char[] arr2 = new char[n];

			for (int i = 0; i < 2; i++) {
				String input = br.readLine();
				if (i == 0) {
					for (int j = 0; j < n; j++) {
						arr1[j] = input.charAt(j) - '0';
					}
				} else {
					for (int j = 0; j < n; j++) {
						arr2[j] = input.charAt(j);
					}
				}
			}

			for (int i = 0; i < n; i++) {
				if (arr2[i] == '#') {
					if (i == 0) {
						if (arr1[i] > 0 && arr1[i + 1] > 0) {
							arr1[i]--;
							arr1[i + 1]--;
							arr2[i] = '*';
						}
					} else if (i > 0 && i < n - 1) {
						if (arr1[i - 1] > 0 && arr1[i] > 0 && arr1[i + 1] > 0) {
							arr1[i]--;
							arr1[i + 1]--;
							arr1[i - 1]--;
							arr2[i] = '*';
						}
					} else {
						if (arr1[i] > 0 && arr1[i - 1] > 0) {
							arr1[i]--;
							arr1[i - 1]--;
							arr2[i] = '*';
						}

					}
				}
			}
			int answer = 0;
			for (char c : arr2) {
				if (c == '*') {
					answer++;
				}
			}
			sb.append(answer).append("\n");
		}

		System.out.println(sb);

	}
}
