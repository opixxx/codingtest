package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2468v2 {
	static int[][] arr;
	static int[][] ch;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		int max = -1;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int input = Integer.parseInt(st.nextToken());
				arr[i][j] = input;
				max = Math.max(max, input);
			}
		}

		int answer = Integer.MIN_VALUE;
		for (int i = 0; i <= max; i++) {
			int tmp = getCount(i);
			answer = Math.max(tmp, answer);
		}
		System.out.println(answer);
	}

	private static int getCount(int high) {
		ch = new int[n][n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (ch[i][j] == 0 && arr[i][j] > high) {
					ch[i][j] = 1;
					count++;
					bfs(i, j, high);
				}
			}
		}

		return count;
	}

	private static void bfs(int x, int y, int high) {
		Queue<Pair> q = new ArrayDeque<>();
		q.offer(new Pair(x, y));

		while (!q.isEmpty()) {
			Pair cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n && ch[nx][ny] == 0 && arr[nx][ny] > high) {
					ch[nx][ny] = 1;
					q.offer(new Pair(nx, ny));
				}
			}
		}
	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
