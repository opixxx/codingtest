package Programmers;

import java.util.HashMap;

public class 성격유형검사 {
	static int[] point = {0, 3, 2, 1, 0, 1, 2, 3};

	public String solution(String[] survey, int[] choices) {
		String answer = "";
		char[] result = new char[4];

		HashMap<Character, Integer> map = new HashMap<>();

		map.put('A', 0);
		map.put('N', 0);
		map.put('C', 0);
		map.put('F', 0);
		map.put('M', 0);
		map.put('J', 0);
		map.put('R', 0);
		map.put('T', 0);

		for (int i = 0; i < choices.length; i++) {
			String s = survey[i];
			int c = choices[i];

			if (c == 4) continue;
			if (c < 4) {
				char a = s.charAt(0);
				map.put(a, map.get(a) + point[c]);
			} else {
				char b = s.charAt(1);
				map.put(b, map.get(b) + point[c]);
			}
		}

		int A = map.get('A');
		int N = map.get('N');
		int C = map.get('C');
		int F = map.get('F');
		int M = map.get('M');
		int J = map.get('J');
		int R = map.get('R');
		int T = map.get('T');

		result[0] = R >= T ? 'R' : 'T';
		result[1] = C >= F ? 'C' : 'F';
		result[2] = J >= M ? 'J' : 'M';
		result[3] = A >= N ? 'A' : 'N';

		for(char e : result) {
			answer += e;
		}

		return answer;
	}
}
