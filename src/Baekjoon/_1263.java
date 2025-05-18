package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _1263 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		List<Time> time = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			time.add(new Time(t, s));
		}
		time.sort(Comparator.comparingInt((Time a) -> a.s).reversed());

		int answer = time.get(0).s;

		for (int i = 0; i < n; i++) {
			answer = Math.min(answer, time.get(i).s) - time.get(i).t;
			if (answer < 0) {
				answer = - 1;
				break;
			}
		}
		System.out.println(answer);

	}

	static class Time {
		int t;
		int s;

		public Time(int t, int s) {
			this.t = t;
			this.s = s;
		}
	}
}
