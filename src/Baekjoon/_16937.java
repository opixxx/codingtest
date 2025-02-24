package Baekjoon;

import java.io.*;
import java.util.*;

public class _16937 {
	static int h, w, n;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(br.readLine());

		List<Pair> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new Pair(r, c));
		}

		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				solution(list.get(i), list.get(j));
			}
		}

		System.out.print(answer);
	}

	static void solution(Pair a, Pair b) {
		int c, d, e, f;

		if (a.r <= h && a.c <= w) { //제대로 붙이는 경우
			c = w - a.c;
			d = h;

			e = h - a.r;
			f = w;

			if (c >= b.r && d >= b.c) {
				int result = (a.r * a.c) + (b.r * b.c);
				answer = Math.max(answer, result);
				return;
			}

			if (e >= b.r && f >= b.c) {
				int result = (a.r * a.c) + (b.r * b.c);
				answer = Math.max(answer, result);
				return;
			}

			if (c >= b.c && d >= b.r) {
				int result = (a.r * a.c) + (b.r * b.c);
				answer = Math.max(answer, result);
				return;
			}

			if (e >= b.c && f >= b.r) {
				int result = (a.r * a.c) + (b.r * b.c);
				answer = Math.max(answer, result);
			}
		}

		if (a.r <= w && a.c <= h) {
			c = w - a.r;
			d = h;

			e = h - a.c;
			f = w;

			if (c >= b.r && d >= b.c) {
				int result = (a.r * a.c) + (b.r * b.c);
				answer = Math.max(answer, result);
				return;
			}

			if (e >= b.r && f >= b.c) {
				int result = (a.r * a.c) + (b.r * b.c);
				answer = Math.max(answer, result);
				return;
			}

			if (c >= b.c && d >= b.r) {
				int result = (a.r * a.c) + (b.r * b.c);
				answer = Math.max(answer, result);
				return;
			}

			if (e >= b.c && f >= b.r) {
				int result = (a.r * a.c) + (b.r * b.c);
				answer = Math.max(answer, result);
			}
		}
	}

	static class Pair {
		int r;
		int c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
