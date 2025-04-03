package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1174v2 {
	static List<Long> list;
	static int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();

		dfs(0, 0);
		Collections.sort(list);

		System.out.println(list.size() < n ? -1 : list.get(n - 1));
	}

	static void dfs(int index, long num) {
		if (!list.contains(num)) {
			list.add(num);
		}

		if (index == 10) {
			return;
		}

		dfs(index + 1, (num * 10) + arr[index]);
		dfs(index + 1, num);

	}
}
