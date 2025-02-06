package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2885v2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int[] ans = new int[2];

		int size = 1;
		int cnt = 0;
		while (size < k) {
			size = size * 2;
		}
		ans[0] = size;

		while (k > 0) {
			if (k >= size) {
				k -= size;
			} else {
				size /= 2;
				cnt++;
			}
		}
		ans[1] = cnt;
		System.out.println(ans[0] + " " + ans[1]);

	}
}
