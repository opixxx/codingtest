package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();

		int w = 0;
		int m = 0;
		int idx = 0;
		int answer = 0;
		while (idx < arr.length) {
			if (canEnter(arr[idx], m, w, n)) {
				if (arr[idx] == 'M') m++;
				else w++;
				idx++;
				answer++;
			} else {
				if (idx + 1 < arr.length && canEnter(arr[idx + 1], m, w, n)) {
					if (arr[idx + 1] == 'M') m++;
					else w++;
					answer++;

					char tmp = arr[idx];
					arr[idx] =arr[idx +1];
					arr[idx + 1] = tmp;
					idx++;
				} else {
					break;
				}
			}
		}
		System.out.println(answer);
	}

	static boolean canEnter(char c, int m, int w, int n) {
		if (c == 'M') m++;
		else w++;
		return Math.abs(m - w) <= n;
	}
}
