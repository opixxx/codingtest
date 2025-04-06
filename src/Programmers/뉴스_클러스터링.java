package Programmers;

import java.util.ArrayList;
import java.util.List;

public class 뉴스_클러스터링 {
	public int solution(String str1, String str2) {
		//a 97 z 122
		int answer = 0;

		String a = str1.toLowerCase();
		String b = str2.toLowerCase();

		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();

		for (int i = 0; i < a.length() - 1; i++) {
			String tmp = a.substring(i, i + 2);
			char c1 = tmp.charAt(0);
			char c2 = tmp.charAt(1);

			if (c1 >= 97 && c1 <= 122 && c2 >= 97 && c2 <= 122) {
				list1.add(tmp);
			}
		}

		for (int i = 0; i < b.length() - 1; i++) {
			String tmp = b.substring(i, i + 2);
			char c1 = tmp.charAt(0);
			char c2 = tmp.charAt(1);

			if (c1 >= 97 && c1 <= 122 && c2 >= 97 && c2 <= 122) {
				list2.add(tmp);

			}
		}

		if (list1.isEmpty() && list2.isEmpty()) {
			return 65536;
		}

		List<String> d = new ArrayList<>(); //합집합
		List<String> e = new ArrayList<>(); //교집합

		for (String tmp : list1) {
			if (list2.contains(tmp)) {
				list2.remove(tmp);
				e.add(tmp);
			}
			d.add(tmp);
		}

		d.addAll(list2);

		System.out.print(e.size() + " " + d.size());

		double f = (double)e.size() / (double)d.size();

		answer = (int)(f * 65536);
		return answer;

	}
}
