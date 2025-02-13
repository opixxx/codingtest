package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _1713 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //사진틀 수
 		int m = Integer.parseInt(br.readLine()); //추천 횟수

		HashMap<Integer, Integer> map = new LinkedHashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int student = Integer.parseInt(st.nextToken());

			if (map.containsKey(student)) {
				map.put(student, map.get(student) + 1);
			} else {
				if (map.size() == n) {
					int key = map.entrySet().stream()
						.min(Comparator.comparingInt(Map.Entry::getValue))
						.map(Map.Entry::getKey)
						.orElseThrow();

					map.remove(key);
				}
				map.put(student, 1);
			}
		}

		map.keySet().stream().sorted().forEach(key -> System.out.print(key + " "));
	}
}
