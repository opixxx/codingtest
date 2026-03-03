package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1497 {
	static int N, M, minGuitarCount = Integer.MAX_VALUE;
	static int max = 0;
	static long[] mask;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		mask = new long[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			String s = st.nextToken();

			long bit = 0L;
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == 'Y') {
					bit |= (1L << j);
				}
			}
			mask[i] = bit;
		}
		solution(0, 0L, 0);
		if (minGuitarCount == 0) {
			minGuitarCount = -1;
		}
		System.out.println(minGuitarCount);

	}

	static void solution(int idx, long guitarMask, int val) {
		int bitCount = Long.bitCount(guitarMask);

		if (bitCount == max && val < minGuitarCount) {
			minGuitarCount = val;
		}

		if (bitCount > max) {
			minGuitarCount = val;
			max = bitCount;
		}

		if (bitCount == M || idx == N) {
			return;
		}

		solution(idx + 1, guitarMask | mask[idx], val + 1);
		solution(idx + 1, guitarMask, val);

	}
}