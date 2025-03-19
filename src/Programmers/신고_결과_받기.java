package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 신고_결과_받기 {
	static List<List<Integer>> in;  //신고를 받은
	static List<List<Integer>> out; //신고를 한
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < id_list.length; i++) {
			map.put(id_list[i], i);
		}

		in = new ArrayList<>();
		out = new ArrayList<>();
		for (int i = 0; i < id_list.length; i++) {
			in.add(new ArrayList<>());
			out.add(new ArrayList<>());
		}

		for (String value : report) {
			String[] s = value.split(" ");

			String a = s[0]; //신고를 한 사람
			String b = s[1]; //신고를 당한 사람

			int aNum = map.get(a);
			int bNum = map.get(b);
			if (out.get(aNum).contains(bNum)) {
				continue;
			}

			out.get(aNum).add(bNum); //신고를 한 연결리스트
			in.get(bNum).add(aNum); //신고를 당한 연결리스트
		}


		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < in.size(); i++) {
			List<Integer> tmp = in.get(i);
			if (tmp.size() >= k) {
				list.add(i);
			}
		}

		if (list.isEmpty()) {
			Arrays.fill(answer, 0);
		} else {
			for (int target : list) {
				for (int j = 0; j < out.size(); j++) {
					List<Integer> tmp = out.get(j);
					for (int v : tmp) {
						if (v == target) {
							answer[j]++;
						}
					}
				}
			}
		}

		return answer;
	}
}

