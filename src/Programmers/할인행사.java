package Programmers;

import java.util.HashMap;

public class 할인행사 {
	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < want.length; i++) {
			map.put(want[i], number[i]);
		}
		HashMap<String, Integer> tmp = new HashMap<>();

		for (int i = 0; i < discount.length - 9; i++) {
			tmp = new HashMap<>(map);

			for(int j = i; j < i + 10; j++) {
				String str = discount[j];
				if (tmp.containsKey(str)) {
					if (tmp.get(str) - 1 == 0) {
						tmp.remove(str);
					} else {
						tmp.put(str, tmp.get(str) - 1);
					}
				}
			}

			if (tmp.isEmpty()) answer++;
		}
		return answer;
	}
}
