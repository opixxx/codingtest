package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 개인정보_수집_유효기간 {
	static HashMap<String, Integer> map;
	public int[] solution(String today, String[] terms, String[] privacies) {

		map = new HashMap<>();

		int changeToday = changeDate(today);

		for (String term : terms) {
			String[] str = term.split(" ");
			map.put(str[0], Integer.parseInt(str[1]));
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < privacies.length; i++) {
			String[] privacy = privacies[i].split(" ");
			if (changeDate(privacy[0]) + (map.get(privacy[1]) * 28) <= changeToday) {
				list.add(i + 1);
			}
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	static int changeDate(String date) {
		String[] arr = date.split("\\.");
		int year = Integer.parseInt(arr[0]);
		int month = Integer.parseInt(arr[1]);
		int day = Integer.parseInt(arr[2]);

		return (year * 12 * 28) + (month * 28) + day;
	}
}