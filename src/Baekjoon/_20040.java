package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20040 {
	static int[] unf;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		unf = new int[n];
		for (int i = 0; i < n; i++) {
			unf[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (find(x) == find(y)) {
				System.out.println(i + 1);
				return;
			} else {
				union(x, y);
			}
		}
		System.out.println(0);
	}

	static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if (fa != fb) {
			unf[fa] = fb;
		}
	}

	static int find(int v) {
		if (v == unf[v]) {
			return v;
		} else {
			return unf[v] = find(unf[v]);
		}
	}
}
