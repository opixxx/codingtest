package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1244 {
	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 성별
			int b = Integer.parseInt(st.nextToken()); // 번호

			solution(a, b);
		}

		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0) System.out.println();
		}

	}

	static void solution(int a, int b) {
		if (a == 1) { //남자
			for (int i = b; i <= n; i += b) {
				arr[i] = arr[i] == 0 ? 1 : 0;
			}

		} else if (a == 2) { //여자
			arr[b] = arr[b] == 0 ? 1 : 0;
			for (int i = 1; b - i >= 1 && b + i <= n; i++) {
				if (arr[b - i] == arr[b + i]) {
					arr[b - i] = arr[b - i] == 0 ? 1 : 0;
					arr[b + i] = arr[b + i] == 0 ? 1 : 0;
				} else {
					break;
				}
			}
		}
	}
}

