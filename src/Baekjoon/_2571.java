package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2571 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());



		int[][] arr = new int[101][101];

		for (int[] row : arr) {
			Arrays.fill(row, -100001);
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			for (int j = a; j < a + 10; j++) {
				for (int k = b; k < b + 10; k++) {
					arr[j][k] = 1;
				}
			}
		}

		int[][] prefixSum = new int[101][101];

		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				prefixSum[i][j] = arr[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
			}
		}

		int answer = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <=100 ; j++) {
				for (int k = i + 1; k <= 100; k++) {
					for (int l = j + 1; l <= 100; l++) {
						int a = prefixSum[k][l] - prefixSum[i - 1][l] - prefixSum[k][j - 1] + prefixSum[i - 1][j - 1];
						if (a < 0) break;
						answer = Math.max(a, answer);
					}
				}
			}
		}

		System.out.println(answer);
	}
}
