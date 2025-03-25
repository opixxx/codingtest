package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class _1005 {
	static int n, m;
	static List<List<Integer>> graph;
	static int[] indeg;
	static int[] done;
	static int[] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			indeg = new int[n + 1];
			done = new int[n + 1];
			arr = new int[n + 1];
			graph = new ArrayList<>();

			for (int j = 0; j <= n; j++) {
				graph.add(new ArrayList<>());
			}

			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph.get(x).add(y);
				indeg[y]++;
			}

			int w = Integer.parseInt(br.readLine());
			solution(w);
		}
	}

	static void solution(int w) {
		Deque<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			if (indeg[i] == 0) {
				q.offer(i);
				done[i] = arr[i];
			}
		}

		while (!q.isEmpty()) {
			int x = q.poll();
			for (int y : graph.get(x)) {
				indeg[y]--;
				if (indeg[y] == 0) {
					q.offer(y);
				}
				done[y] = Math.max(done[y], done[x] + arr[y]);
			}
		}
		System.out.println(done[w]);
	}

}
