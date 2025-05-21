package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17253 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		boolean flag = true;
		if (n == 0) {
			System.out.println("NO");
			return;
		}
		while (n > 0) {
			if (n % 3 == 2) {
				flag = false;
				break;
			}
			n = n / 3;
		}
		System.out.println(flag ? "YES" : "NO");

	}
}
