package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1025 {

	static int n, m;
	static int[][] arr;
	static int answer = -1;
	public static void main(String[] args) throws IOException {
		input();
		solution();
	}

	static void solution() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = -n; k < n; k++) {
					for (int l = -m; l < m; l++) {
						if (k == 0 && l == 0) {
							continue;
						}

						int num = 0;
						int newRow = i;
						int newCol = j;

						while (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
							num = num * 10 + arr[newRow][newCol];

							if (isAnswer(num)) {
								answer = Math.max(answer, num);
							}
							newRow += k;
							newCol += l;
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

	static boolean isAnswer(int num) {
		int sqrt = (int) Math.sqrt(num);
		return sqrt * sqrt == num;
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
	}
}
