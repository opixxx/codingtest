package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _9205v2 {
	static int startX;
	static int startY;
	static int targetX;
	static int targetY;
	static boolean[] ch;
	static List<Node> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); //테스트 수

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {

			int n = Integer.parseInt(br.readLine()); //편의점 수
			list = new ArrayList<>();
			for (int j = 0; j < n + 2; j++) {
				ch = new boolean[n];
				StringTokenizer	st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				if (j == n + 1) {
					targetX = x;
					targetY = y;
				} else if (j == 0) {
					startX = x;
					startY = y;
				} else {
					list.add(new Node(x, y));
				}
			}

			if (bfs()) {
				sb.append("happy\n");
			} else {
				sb.append("sad\n");
			}



		}
		System.out.println(sb);
	}

	static boolean bfs() {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(startX, startY));

		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (Math.abs(cur.x - targetX) + Math.abs(cur.y - targetY) <= 1000) {
				return true;
			}

			for (int i = 0; i < list.size(); i++) {
				if (!ch[i]) {
					int nx = list.get(i).x;
					int ny = list.get(i).y;
					if (Math.abs(cur.x - nx) + Math.abs(cur.y - ny) <= 1000) {
						q.offer(new Node(nx, ny));
						ch[i] = true;
					}
				}
			}
		}
		return false;
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
