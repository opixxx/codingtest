package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _18869 {
	static int m, n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken()); //우주의 수
		n = Integer.parseInt(st.nextToken()); //행성 수

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int[] row = new int[n];

			for (int j = 0; j < n; j++) {
				row[j] = Integer.parseInt(st.nextToken());
			}
			int[] sorted = row.clone();
			Arrays.sort(sorted);


			HashMap<Integer, Integer> rankMap = new HashMap<>();
			int rank = 0;
			rankMap.put(sorted[0], 0);

			for (int j = 1; j < n; j++) {
				if (sorted[j] != sorted[j - 1]) {
					rank++;
				}
				rankMap.put(sorted[j], rank);
			}

			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				sb.append(rankMap.get(row[j])).append(" ");
			}

			String pattern = sb.toString();

			map.put(pattern, map.getOrDefault(pattern, 0) + 1);
		}

		long answer = 0;
		for (Integer value : map.values()) {
			answer += (long)value * (value - 1) / 2;
		}

		System.out.println(answer);

	}
}