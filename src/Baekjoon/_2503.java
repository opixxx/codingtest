package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _2503 {
	static boolean[] ch;
	static List<Triple> list;
	static List<String> answer = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ch = new boolean[10];
		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String num = st.nextToken();
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.add(new Triple(num, s, b));
		}

		dfs("", 0);
		System.out.println(answer.size());


	}

	static void dfs(String num, int level) {
		if (level == 3) {
			isPossible(num);
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (!ch[i]) {
				ch[i] = true;
				dfs(num + i, level + 1);
				ch[i] = false;
			}
		}
	}

	static void isPossible(String num) {
		for (Triple triple : list) {
			int strike = 0;
			int ball = 0;
			String curNum = triple.num;

			for (int i = 0; i < 3; i++) {
				if (curNum.charAt(i) == num.charAt(i)) {
					strike++;
				}
			}

			if (triple.s != strike) {
				return;
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i==j) continue;
					if (curNum.charAt(i) == num.charAt(j)) {
						ball++;
					}
				}
			}
			if (triple.b != ball) {
				return;
			}
		}
		answer.add(num);
	}

	static class Triple {
		String num;
		int s;
		int b;

		public Triple(String num, int s, int b) {
			this.num = num;
			this.s = s;
			this.b = b;
		}
	}
}
