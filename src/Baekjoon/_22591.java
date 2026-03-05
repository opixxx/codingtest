package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _22591 {
	static final int[] SEG = {
		0b1110111, // 0
		0b0010010, // 1
		0b1011101, // 2
		0b1011011, // 3
		0b0111010, // 4
		0b1101011, // 5
		0b1101111, // 6
		0b1010010, // 7
		0b1111111, // 8
		0b1111011  // 9
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		int[][] cost = new int[10][10];

		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				cost[i][j] = Integer.bitCount(SEG[i] ^ SEG[j]);
			}
		}

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			if (i == x) {
				continue;
			}

			int change = getChanges(x, i, k, cost);

			if (change >= 1 && change <= p) answer++;
		}
		System.out.println(answer);
	}

	static int getChanges(int x, int target, int k, int[][] cost) {
		int total = 0;
		for (int j = 0; j < k; j++) {
			int xd = x % 10;
			int td = target % 10;

			total += cost[xd][td];

			x /= 10;
			target /= 10;
		}
		return total;

	}
}
