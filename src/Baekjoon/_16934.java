package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16934 {
	static String A;
	static int B;
	static boolean[] ch;
	static char[] arr;
	static int answer = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = st.nextToken();
		B = Integer.parseInt(st.nextToken());

		arr = A.toCharArray();
		ch = new boolean[A.length()];

		dfs("", 0);
		System.out.print(answer);
	}

	static void dfs(String num, int level) {
		if (level == A.length()) {
			int result = Integer.parseInt(num);
			if (result < B && String.valueOf(result).length() == A.length()) {
				answer = Math.max(answer, result);
			}
		}

		for (int i = 0; i < A.length(); i++) {
			if (!ch[i]) {
				ch[i] = true;
				dfs(num + arr[i], level + 1);
				ch[i] = false;
			}
		}
	}
}
