package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _30190 {
	static final long MOD = 1_000_000_007L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] a = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}


		long[] pow = new long[N + 1];
		pow[0] = 1;
		for (int i = 1; i <= N; i++) {
			pow[i] = (pow[i - 1] * 2) % MOD;
		}

		long ans = 0;
		int src = K;


		for (int i = N - 1; i >= 0; i--) {
			int dst = a[i];

			if (src == dst) continue;

			ans = (ans + pow[i]) % MOD;

			src = 6 - src - dst;
		}

		System.out.println(ans);
	}
}
