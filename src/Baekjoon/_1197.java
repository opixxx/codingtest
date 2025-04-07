package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _1197 {
	static int[] unf;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		unf = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			unf[i] = i;
		}

		List<Node> list = new ArrayList<>();
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.add(new Node(a, b, c));
		}

		list.sort(Comparator.comparingInt(a -> a.cost));
		int answer = 0;
		for (Node node : list) {
			int fv1 = find(node.start);
			int fv2 = find(node.end);
			if (fv1 != fv2) {
				answer += node.cost;
				union(node.start, node.end);
			}
		}
		System.out.println(answer);

	}

	static int find(int v) {
		if (v == unf[v]) {
			return v;
		} else {
			return unf[v] = find(unf[v]);
		}
	}

	static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if (fa != fb) {
			unf[fa] = fb;
		}
	}

	static class Node {
		int start;
		int end;
		int cost;

		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
}
