package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1522 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		char[] arr = input.toCharArray();

		int countA = 0;
		for (char c : arr) {
			if (c == 'a') {
				countA++;
			}
		}

		if (countA == 0 || countA == arr.length) {
			System.out.println(0);
			return;
		}

		int countB = 0;
		for (int i = 0; i < countA; i++) {
			if (arr[i] == 'b')
				countB++;
		}
		int answer = countB;
		for (int start = 1; start < arr.length; start++) {
			int outIdx = start - 1;
			int inIdx = (start + countA - 1) % arr.length;
			if (arr[outIdx] == 'b') countB--;
			if (arr[inIdx] == 'b') countB++;

			answer = Math.min(answer, countB);
		}

		System.out.println(answer);

	}
}
