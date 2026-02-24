package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _12018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			if (p < l) {
				list.add(1);
				br.readLine();
			} else {
				int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				Arrays.sort(tmp);
				int idx = tmp.length - l;
				list.add(tmp[idx]);
			}
		}

		Collections.sort(list);

		int sum = 0;
		int answer = list.size();
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
			if (sum > m) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
}
