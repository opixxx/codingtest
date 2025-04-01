package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11060v2 {
	static int[] a;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		a = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(bfs());
	}

	private static int bfs() {
		if (n == 1) {
			return 0;
		}
		Queue<Pair> q = new ArrayDeque<>();
		boolean[] ch = new boolean[n];

		q.offer(new Pair(0, 0));
		ch[0] = true;

		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int curI = cur.i;
			int canJump = cur.jump;

			for (int i = curI + 1; i <= curI + a[curI]; i++) {
				if (i < n) {
					if (i == n - 1) {
						return canJump + 1;
					}
					if (!ch[i]) {
						ch[i] = true;
						q.offer(new Pair(i, canJump + 1));
					}
				}
			}
		}

		return -1;
	}

	static class Pair {
		int i;
		int jump;

		public Pair(int i, int jump) {
			this.i = i;
			this.jump = jump;
		}

	}
}
