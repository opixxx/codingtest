package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1245 {
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
	static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					if (bfs(i, j)) answer++;
				}
			}
		}
		System.out.println(answer);

	}

	static boolean bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;

		int height = map[x][y];
		boolean isPeak = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];

			for (int i = 0; i < 8; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (map[nx][ny] > height) {
					isPeak = false;
				}
				if (map[nx][ny] == height && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new int[]{nx, ny});
				}
			}
		}
		return isPeak;
	}

}
