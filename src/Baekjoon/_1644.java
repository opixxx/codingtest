package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _1644 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if (n < 2) {
			System.out.println(0);
			return;
		}

		boolean[] isComposite = new boolean[n + 1];
		List<Integer> primes = new ArrayList<>();

		for (int i = 2; i <= n; i++) {
			if (!isComposite[i]) {
				primes.add(i);
				if ((long)i * i <= n) {
					for (int j = i * i; j <= n; j += i) {
						isComposite[j] = true;
					}
				}
			}
		}

		int l = 0;
		int r = 0;
		long sum = 0;
		int count = 0;

		while (true) {
			if (sum >= n) {
				if (sum == n) {
					count++;
				}
				sum -= primes.get(l++);
			} else {
				if (r == primes.size()) {
					break;
				}
				sum += primes.get(r++);
			}
		}
		System.out.println(count);
	}
}
