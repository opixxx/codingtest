package Programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class 미로_탈출_명령어 {

	static int startX, startY, targetX, targetY;
	static char[][] map;
	static boolean[][][] ch;
	static int[] dx = {1, 0, 0, -1}; // d l r u
	static int[] dy = {0, -1, 1, 0};
	static String[] result = {"d", "l", "r", "u"};

	public String solution(int n, int m, int x, int y, int r, int c, int k) {
		String answer = "";
		map = new char[n][m];
		ch = new boolean[n][m][k + 2];

		startX = x - 1;
		startY = y - 1;
		targetX = r - 1;
		targetY = c - 1;
		for (char[] tmp : map) {
			Arrays.fill(tmp, '.');
		}

		map[startX][startY] = 'S';
		map[targetX][targetY] = 'E';

		List<String> list = bfs(n, m, k);

		if (list.isEmpty()) {
			answer = "impossible";
		} else {
			Collections.sort(list);
			answer = list.get(0);
		}

		return answer;
	}

	List<String> bfs(int n, int m, int k) {
		Queue<Maze> q = new ArrayDeque<>();
		q.offer(new Maze(startX, startY, 0, ""));
		ch[startX][startY][0] = true;
		List<String> list = new ArrayList<>();

		while(!q.isEmpty()) {
			var cur = q.poll();

			if (cur.dis > k) continue;
			if (cur.x == targetX && cur.y == targetY && cur.dis == k) {
				list.add(cur.str);
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m && !ch[nx][ny][cur.dis + 1]) {
					ch[nx][ny][cur.dis + 1] = true;
					q.offer(new Maze(nx, ny, cur.dis + 1, cur.str + result[i]));
				}
			}
		}

		return list;
	}
	static class Maze {
		int x;
		int y;
		int dis;
		String str;

		public Maze(int x, int y, int dis, String str) {
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.str = str;
		}
	}
}
