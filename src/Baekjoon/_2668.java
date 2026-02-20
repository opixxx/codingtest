package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2668 {
	static boolean[] visited;
	static int n;
	static int[] arr;
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		list = new ArrayList<>();

		visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (Integer i : list) {
			System.out.println(i);
		}
	}

	static void dfs(int start, int target) {
		if (!visited[arr[start]]) {
			visited[arr[start]] = true;
			dfs(arr[start], target);
			visited[arr[start]] = false;
		}

		if (arr[start] == target) {
			list.add(target);
		}
	}
}
