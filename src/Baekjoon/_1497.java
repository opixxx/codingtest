package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1497 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] mask = new long[N];

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

		int bestSongCnt = 0;
		int bestGuitarCnt = Integer.MAX_VALUE;

		for (int subset = 1; subset < (1 << N); subset++) {
			long songs = 0L;
			int guitarCnt = 0;

			for (int i = 0; i < N; i++) {
				if ((subset & (1 << i)) != 0) {
					songs |= mask[i];
					guitarCnt++;
				}
			}

			int songCnt = popCount(songs);

			if (songCnt > bestSongCnt) {
				bestSongCnt = songCnt;
				bestGuitarCnt = guitarCnt;
			} else if (songCnt == bestSongCnt && songCnt > 0) {
				bestGuitarCnt = Math.min(bestGuitarCnt, guitarCnt);
			}
		}

		// 한 곡도 못 치면 -1
		if (bestSongCnt == 0) System.out.println(-1);
		else System.out.println(bestGuitarCnt);
	}

	static int popCount(long x) {
		return Long.bitCount(x);
	}
}