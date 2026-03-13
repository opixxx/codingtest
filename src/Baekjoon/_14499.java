package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14499 {
	static int n, m, x, y, k;
	static int[] dx = {0, 0, 0, -1, 1};
	static int[] dy = {0, 1, -1, 0, 0};
	static int[] dice;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		// 0 -> 위, 1 -> 아래, 2 -> 북, 3 -> 남, 4 -> 서, 5 -> 동
		dice = new int[6];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < k; i++) {
			int command = Integer.parseInt(st.nextToken());

			int nx = x + dx[command];
			int ny = y + dy[command];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
				continue;
			}
			x = nx;
			y = ny;

			if (command == 1) rollEast();
			else if (command == 2) rollWest();
			else if (command == 3) rollNorth();
			else if (command == 4) rollSouth();

			if (map[x][y] == 0) {
				map[x][y] = dice[1];
			} else {
				dice[1] = map[x][y];
				map[x][y] = 0;
			}

			sb.append(dice[0]).append("\n");

		}
		System.out.println(sb);

	}

	static void rollEast() {
		int top = dice[0];
		int bottom = dice[1];
		int north = dice[2];
		int south = dice[3];
		int west = dice[4];
		int east = dice[5];

		dice[0] = west;
		dice[1] = east;
		dice[2] = north;
		dice[3] = south;
		dice[4] = bottom;
		dice[5] = top;
	}

	static void rollWest() {
		int top = dice[0];
		int bottom = dice[1];
		int north = dice[2];
		int south = dice[3];
		int west = dice[4];
		int east = dice[5];

		dice[0] = east;
		dice[1] = west;
		dice[2] = north;
		dice[3] = south;
		dice[4] = top;
		dice[5] = bottom;
	}

	static void rollNorth() {
		int top = dice[0];
		int bottom = dice[1];
		int north = dice[2];
		int south = dice[3];
		int west = dice[4];
		int east = dice[5];

		dice[0] = south;
		dice[1] = north;
		dice[2] = top;
		dice[3] = bottom;
		dice[4] = west;
		dice[5] = east;
	}

	static void rollSouth() {
		int top = dice[0];
		int bottom = dice[1];
		int north = dice[2];
		int south = dice[3];
		int west = dice[4];
		int east = dice[5];

		dice[0] = north;
		dice[1] = south;
		dice[2] = bottom;
		dice[3] = top;
		dice[4] = west;
		dice[5] = east;
	}
}
