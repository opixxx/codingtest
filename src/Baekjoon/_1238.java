package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1238 {
	static List<List<Node>> list;
	static List<List<Node>> reversList;
	static int[] dis;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		reversList = new ArrayList<>();
		dis = new int[n + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);


		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
			reversList.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.get(a).add(new Node(b, c));
			reversList.get(b).add(new Node(a, c));
		}
		int[] d = dijkstra(x, list);
		int[] e = dijkstra(x, reversList);

		int answer = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			answer = Math.max(answer, d[i] + e[i]);
		}
		System.out.println(answer);
	}

	static int[] dijkstra(int root, List<List<Node>> list) {
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
		dis = new int[n + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);

		dis[root] = 0;
		pq.offer(new Node(root, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int end = cur.end;
			int cost = cur.cost;

			for (Node node : list.get(end)) {
				if (dis[node.end] > cost + node.cost) {
					dis[node.end] = cost + node.cost;
					pq.offer(new Node(node.end, cost + node.cost));

				}
			}
		}

		return dis;

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
