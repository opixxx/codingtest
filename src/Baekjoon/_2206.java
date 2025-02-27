package Baekjoon;

import java.io.*;
import java.util.*;

public class _2206 {
	static int n, m;
	static int[][] arr;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static boolean[][][] ch;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		ch = new boolean[n][m][2];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}

		System.out.print(bfs());
	}

	static int bfs() {
		Queue<Pair> q = new ArrayDeque<>();
		q.offer(new Pair(0, 0, 1, 0));
		ch[0][0][0] = true;

		while (!q.isEmpty()) {
			var cur = q.poll();

			if (cur.x == n - 1 && cur.y == m - 1) {
				return cur.count;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (arr[nx][ny] == 0 && !ch[nx][ny][cur.wall]) {
						ch[nx][ny][cur.wall] = true;
						q.offer(new Pair(nx, ny, cur.count + 1, cur.wall));
					}

					if (arr[nx][ny] == 1 && cur.wall == 0 && !ch[nx][ny][1]) {
						ch[nx][ny][1] = true;
						q.offer(new Pair(nx, ny, cur.count + 1, 1));
					}
				}
			}
		}

		return -1;

	}

	static class Pair {
		int x;
		int y;
		int count;
		int wall;
		public Pair(int x, int y, int count, int wall) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.wall = wall;
		}
	}
}
