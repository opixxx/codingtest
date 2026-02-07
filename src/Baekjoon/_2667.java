package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2667 {
	static int n, count, cnt;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		count = 0;
		arr = new int[n][n];

		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && arr[i][j] == 1) {
					visited[i][j] = true;
					cnt = 1;
					dfs(i, j);
					list.add(cnt);
				}
			}
		}

		Collections.sort(list);

		System.out.println(list.size());
		for (Integer i : list) {
			System.out.println(i);
		}
	}

	static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] == 1 && !visited[nx][ny]) {
				visited[nx][ny] = true;
				cnt++;
				dfs(nx, ny);
			}

		}
	}
}
