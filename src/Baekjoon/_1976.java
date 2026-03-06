package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1976 {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int connect = Integer.parseInt(st.nextToken());

				if (connect == 1) {
					union(i, j);
				}
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		int root = find(first);

		boolean answer = true;
		for (int i = 1; i < m; i++) {
			int city = Integer.parseInt(st.nextToken());
			if (find(city) != root) {
				answer = false;
				break;
			}
		}
		System.out.println(answer ? "YES" : "NO");

	}

	static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if (fa != fb) {
			parent[fa] = fb;
		}
	}
}
