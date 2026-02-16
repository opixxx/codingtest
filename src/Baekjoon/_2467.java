package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2467 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //(2 ~ 100,000)
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int l = 0;
		int r = arr.length - 1;
		int answerL = 0;
		int answerR = arr.length -1 ;

		int min = Math.abs(arr[l] + arr[r]);

		while (l < r) {
			int value = (arr[l] + arr[r]);

			if (min > Math.abs(value)) {
				answerL = l;
				answerR = r;
			}

			min = Math.min(min, Math.abs(value));
			if (value < 0) {
				l++;
			} else {
				r--;
			}

		}
		System.out.println(arr[answerL] + " " + arr[answerR]);
	}
}
