package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1527 {
	static int count = 0;
	static int a, b;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		bfs(0L);

		System.out.println(count);

	}

	static void bfs(long cur) {
		if (cur > b) {
			return;
		}

		if (cur >= a) {
			count++;
		}

		bfs(cur * 10 + 4);
		bfs(cur * 10 + 7);

	}
}
