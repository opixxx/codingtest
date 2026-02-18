package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _1863 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> stack = new ArrayDeque<>();
		int answer = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int h = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty() && stack.peekLast() > h) {
				stack.pollLast();
				answer++;
			}

			if (h > 0 && (stack.isEmpty() || stack.peekLast() < h)) {
				stack.addLast(h);
			}
		}

		answer += stack.size();
		System.out.println(answer);
	}
}
