package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2607 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String target = br.readLine();
		int[] arr = new int[26];

		for (char c : target.toCharArray()) {
			arr[c - 'A']++;
		}

		int answer = 0;


		for (int i = 0; i < n - 1; i++) {
			String input = br.readLine();

			int[] tmp = arr.clone();

			int a = 0;
			for (char c : input.toCharArray()) {
				int idx = c - 'A';
				if (tmp[idx] > 0) tmp[idx]--;
				else a++;
			}
			int b = 0;

			for (int num : tmp) {
				b += num;
			}
			int diff = input.length() - target.length();

			boolean flag = false;
			if (diff == 0) {
				flag =(a == 0 && b == 0) || (a == 1 && b == 1);
			} else if (diff == 1) {
				flag = (a == 1 && b == 0);
			} else if (diff == -1) {
				flag = (a == 0 && b == 1);
			}
			if (flag) answer++;

		}
		System.out.println(answer);



	}
}
