package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _14496 {
	static List<List<Integer>> graph;
	static int a, b, n , m;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());

			graph.get(num1).add(num2);
			graph.get(num2).add(num1);
		}

		System.out.println(solution(a));
	}

	static int solution(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
		visited = new boolean[n + 1];
		pq.add(new Node(start, 0));

		visited[start] = true;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.num == b) {
				return cur.cost;
			}

			for (Integer next : graph.get(cur.num)) {
				if (!visited[next]) {
					visited[next] = true;
					pq.add(new Node(next, cur.cost + 1));
				}
			}
		}
		return -1;
	}

	static class Node {
		int num;
		int cost;

		public Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
	}

}
