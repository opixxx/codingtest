package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1138 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] answer = new int[n];

		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (answer[j] == 0) {
					if (cnt == arr[i]) {
						answer[j] = i;
						break;
					}
					cnt++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(answer[i] + " ");
		}
	}
}
