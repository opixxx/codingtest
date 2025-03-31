package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1068v2 {
	static List<List<Integer>> graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int node = Integer.parseInt(st.nextToken());
			graph.get(node + 1).add(i);
		}

		int remove = Integer.parseInt(br.readLine());
		while (!graph.get(remove + 1).isEmpty()) {
			graph.get(remove + 1).clear();
		}
		for (List<Integer> node : graph) {
			node.remove(Integer.valueOf(remove + 1));
		}

		int answer = dfs(0);
		System.out.println(answer);

	}

	static int dfs(int node) {
		if (node != 0 && graph.get(node).isEmpty()) {
			return 1;
		}

		int count = 0;
		for (int i : graph.get(node)) {
			count += dfs(i);
		}

		return count;
	}
}
