package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _14469 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<Node> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list.add(new Node(x, y));
		}

		list.sort(Comparator.comparingInt(o -> o.a));
		int time = 0;
		for (Node node : list) {
			if (time < node.a) {
				time = node.a;
			}
			time += node.b;
		}
		System.out.println(time);
	}

	static class Node {
		int a;
		int b;

		public Node(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}
