package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1062 {
	static boolean[] ch;
	static List<String> list;
	static int n, k;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(br.readLine());
		}

		if (k < 5) {
			System.out.println(0);
			return;
		}
		ch = new boolean[26];
		ch['a' - 97] = true;
		ch['n' - 97] = true;
		ch['t' - 97] = true;
		ch['i' - 97] = true;
		ch['c' - 97] = true;

		dfs(0, 0);
		System.out.println(answer);
	}

	static int solution() {
		int count = 0;
		boolean flag = true;
		for (String str : list) {
			flag = true;
			for (int i = 0; i < str.length(); i++) {
				if (!ch[str.charAt(i) - 97]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				count++;
			}
		}
		return count;
	}

	static void dfs(int l, int s) {
		if (l == k - 5) {
			answer = Math.max(answer, solution());
			return;
		}
		for (int i = s; i < 26; i++) {
			if (!ch[i]) {
				ch[i] = true;
				dfs(l + 1, i + 1);
				ch[i] = false;
			}
		}
	}
}
