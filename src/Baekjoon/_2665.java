package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class _2665 {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	static int n;
	static int[][] map, dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				int v = input.charAt(j) - '0';
				map[i][j] = v;
			}
		}

		dist = new int[n][n];
		for (int[] arr : dist) {
			Arrays.fill(arr, 1000000);
		}

		dist[0][0] = 0;
		bfs();
		System.out.println(dist[n - 1][n - 1]);
	}

	static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(0, 0));

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					int cost = dist[cur.x][cur.y] + (map[nx][ny] == 0 ? 1 : 0);
					if (dist[nx][ny] > cost) {
						dist[nx][ny] = cost;
						q.offer(new Node(nx, ny));
					}
				}
			}
		}

	}

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
