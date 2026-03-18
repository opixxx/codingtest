package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class _28471 {
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 1};
	static int n;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new char[n][n];
		visited = new boolean[n][n];
		int startX = -1;
		int startY = -1;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'F') {
					startX = i;
					startY = j;
				}
			}
		}

		System.out.println(bfs(startX, startY));
	}

	static int bfs(int x, int y) {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(x, y));
		visited[x][y] = true;

		int answer = 0;
		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 7; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] != '#') {
					visited[nx][ny] = true;
					q.offer(new Point(nx, ny));
					if (map[nx][ny] == '.') {
						answer++;
					}
				}
			}
		}
		return answer;
	}
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
