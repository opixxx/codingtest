package Baekjoon;

import java.io.*;
import java.util.*;

public class _1411 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<String> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(br.readLine());
		}

		list.sort(Comparator.comparingInt(a -> -a.length()));
		System.out.print(solution(list));
	}

	private static int solution(List<String> list) {
		List<String> tmp = new ArrayList<>();

		tmp.add(list.get(0));

		for (int i = 1; i < list.size(); i++) {
			String a = list.get(i); //비교 문자열
			boolean flag = true; //비교 문자열이 tmp의 들어가있는 문자들의 접두어가 되는지 안되는지

			for (String b : tmp) {
				String c = b.substring(0, a.length());
				if (c.equals(a)) {
					flag = false;
				}
			}

			if (flag) {
				tmp.add(a);
			}
		}
		return tmp.size();
	}
}
