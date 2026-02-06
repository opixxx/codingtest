package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _1411 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] words = new String[n];

		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (solution(words[i]).equals(solution(words[j]))) {
					answer++;
				}
			}
		}

		System.out.println(answer);
	}

	static String solution(String word) {
		Map<Character, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		int idx = 0;

		for (char c : word.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, idx++);
			}
			sb.append(map.get(c));
		}

		return sb.toString();
	}
}
