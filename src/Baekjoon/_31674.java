package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _31674 {
	public static final Long MOD = 1_000_000_007L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

		Arrays.sort(arr);

		long answer = 0;
		long pow = 1;

		for (int i = 0; i < n; i++) {
			answer = (answer + arr[i] * pow % MOD) % MOD;
			pow = (pow * 2) % MOD;
		}
		System.out.println(answer);

	}
}
