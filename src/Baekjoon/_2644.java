package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _2644 {
	static List<List<Integer>> list;
	static boolean[] visited;
	static int n, a, b, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); //사람수

		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(br.readLine()); //관계 수

		visited = new boolean[n + 1];
		list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.get(x).add(y);
			list.get(y).add(x);
		}

		System.out.println(bfs());
	}

	static int bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
		pq.offer(new Node(a, 0));
		visited[a] = true;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.end == b) {
				return cur.cost;
			}

			for (Integer next : list.get(cur.end)) {
				if (!visited[next]) {
					visited[next] = true;
					pq.offer(new Node(next, cur.cost + 1));
				}
			}
		}

		return -1;
	}

	static class Node {
		int end;
		int cost;

		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
}
