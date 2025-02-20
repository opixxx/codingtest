package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _12851v2 {
	static int n, k, count;
	static int[] ch;
	static int answer = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());


		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		ch = new int[100001];

		if (n >= k) {
			System.out.println(n - k);
			System.out.println(1);
			return;
		}

		bfs(n);
		System.out.println(answer);
		System.out.println(count);

	}

	private static void bfs(int n) {
		count = 0;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(n);
		ch[n] = 1;

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (answer < ch[cur]) {
				return;
			}

			for (int i = 0; i < 3; i++) {
				int nx = 0;
				if (i == 0) {
					nx = cur + 1;
				} else if (i == 1) {
					nx = cur - 1;
				} else if (i == 2) {
					nx = cur * 2;
				}

				if (nx == k) {
					answer = ch[cur];
					count++;

				}
				if (nx >= 0 && nx <= 100000 && (ch[nx] == 0 || ch[nx] == ch[cur] + 1)) {
					q.offer(nx);
					ch[nx] = ch[cur] + 1;
				}
			}

		}

	}

}
