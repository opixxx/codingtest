package Baekjoon;

import java.io.*;
import java.util.*;

public class _6087 {
	static char[][] map;
	static int w, h;
	static List<int[]> raisers;
	// 우, 좌, 하, 상 (0, 1, 2, 3)
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[][][] ch;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new char[h][w];
		ch = new int[h][w][4];
		raisers = new ArrayList<>();

		for (int i = 0; i < h; i++) {
			String input = br.readLine();
			for (int j = 0; j < w; j++) {
				char c = input.charAt(j);
				map[i][j] = c;

				if (c == 'C') {
					raisers.add(new int[] {i, j});
				}
			}
		}
		System.out.print(bfs());
	}

	static int bfs() {
		PriorityQueue<Raiser> q = new PriorityQueue<>(Comparator.comparingInt(r -> r.mirror));

		int[] start = raisers.get(0);
		int[] target = raisers.get(1);

		for (int i = 0; i < 4; i++) {
			int nx = start[0] + dx[i];
			int ny = start[1] + dy[i];

			if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] != '*') {
				q.offer(new Raiser(nx, ny, i, 0));
				ch[nx][ny][i] = 0;
			}
		}

		while (!q.isEmpty()) {
			Raiser cur = q.poll();

			if (target[0] == cur.x && target[1] == cur.y) {
				return cur.mirror;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] != '*') {
					int nMirror = cur.mirror + (cur.dir == i ? 0 : 1);
					if (ch[nx][ny][i] == 0 || ch[nx][ny][i] > nMirror) {
						q.offer(new Raiser(nx, ny, i, nMirror));
						ch[nx][ny][i] = nMirror;
					}
				}
			}
		}
		return -1;
	}

	static class Raiser {
		int x;
		int y;
		int dir;
		int mirror;

		public Raiser(int x, int y, int dir, int mirror) {
			this.x= x;
			this.y= y;
			this.dir = dir;
			this.mirror = mirror;
		}
	}
}