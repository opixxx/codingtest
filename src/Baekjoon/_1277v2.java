package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1277v2 {
	static int n, w;
	static double m;
	static Node[] node;
	static double[][] dis;
	static double[] distance;
	static final double INF = 200000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		m = Double.parseDouble(br.readLine());

		node = new Node[n + 1];
		distance = new double[n + 1];
		dis = new double[n + 1][n + 1];

		Arrays.fill(distance, INF);
		for (double[] di : dis) {
			Arrays.fill(di, INF);

		}
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			node[i] = new Node(a, b);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) continue;
				Node node1 = node[i];
				Node node2 = node[j];
				double dist = getDistance(node1, node2);
				if (dist <= m) {
					dis[i][j] = dis[j][i] = dist;
				}

			}
		}

		for (int i = 0; i < w; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dis[a][b] = dis[b][a] = 0;
		}

		dijkstra();

		System.out.println((int)(distance[n] * 1000));
	}

	static void dijkstra() {
		PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a.cost));
		distance[1] = 0;
		pq.offer(new Pair(1, 0));

		while (!pq.isEmpty()) {
			Pair cur = pq.poll();

			int curEnd = cur.end;
			double curCost = cur.cost;

			if (distance[curEnd] < curCost) continue;
			for (int nextNode = 1; nextNode <= n; nextNode++) {
				if (dis[curEnd][nextNode] != INF) {
					double newCost = curCost + dis[curEnd][nextNode];
					if (distance[nextNode] > newCost) {
						distance[nextNode] = newCost;
						pq.offer(new Pair(nextNode, newCost));

					}
				}
			}
		}
	}

	static double getDistance(Node node1, Node node2) {
		long dx = (long)Math.pow(node1.x - node2.x, 2);
		long dy = (long)Math.pow(node1.y - node2.y, 2);

		return Math.sqrt(dx + dy);
	}

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Pair {
		int end;
		double cost;

		public Pair(int end, double cost) {
			this.end = end;
			this.cost = cost;
		}
	}
}
