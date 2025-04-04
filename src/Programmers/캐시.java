package Programmers;

import java.util.LinkedList;

public class 캐시 {
	public int solution(int cacheSize, String[] cities) {
		int answer = 0;

		LinkedList<String> LRU = new LinkedList<>();
		if (cacheSize == 0) {
			return cities.length * 5;
		}
		for (String city : cities) {
			String input = city.toLowerCase();

			if (!LRU.isEmpty()) {
				if (LRU.contains(input)) {
					answer += 1;
					if (LRU.size() == cacheSize) {
						LRU.remove(input);
					}
				} else {
					answer+=5;
					if (LRU.size() == cacheSize) {
						LRU.poll();
					}

				}
			} else {
				answer += 5;
			}
			if (cacheSize > 0) {
				LRU.offer(input);
			}
		}

		return answer;
	}
}
