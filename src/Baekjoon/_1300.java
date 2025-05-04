package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		long lt = 0;
		long rt = k;

		while (lt < rt) {
			long mid = (lt + rt) / 2;
			long count = 0;

			for (int i = 1; i <= n; i++) {
				count += Math.min(mid / i, n);
			}

			if (k <= count) {
				rt = mid;
			} else {
				lt = mid + 1;
			}
		}
		System.out.println(lt);
	}
}
