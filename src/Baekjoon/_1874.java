package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> st = new Stack<>();
		int start = 0;

		StringBuilder sb = new StringBuilder();

		while (n-- > 0) {
			int num = Integer.parseInt(br.readLine());

			if (start < num) {
				for (int i = start + 1; i <= num; i++) {
					st.push(i);
					sb.append("+").append("\n");
				}

				start = num;
			} else if (st.peek() != num) {
				System.out.println("NO");
				return;
			}

			st.pop();
			sb.append("-").append("\n");

		}

		System.out.println(sb);

	}
}
