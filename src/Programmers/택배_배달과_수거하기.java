package Programmers;

import java.util.Stack;

public class 택배_배달과_수거하기 {
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;
		int len = deliveries.length;
		Stack<int[]> st1 = new Stack<>();
		Stack<int[]> st2 = new Stack<>();

		for (int i = 0; i < len; i++) {
			int d = deliveries[i];
			int p = pickups[i];

			st1.push(new int[]{i + 1, d});
			st2.push(new int[]{i + 1, p});
		}

		while(!st1.isEmpty() || !st2.isEmpty()) {
			int s1 = st1.peek()[1];
			int s2 = st2.peek()[1];

			if(s1 > 0 || s2 > 0) break;

			if (s1 == 0 && s2 == 0) {
				st1.pop();
				st2.pop();
			}
		}

		while(true) {
			int tmp = cap;

			if (st1.isEmpty() && st2.isEmpty()) {
				break;
			}
			int targetLen = Math.max(st1.size(), st2.size());

			answer += targetLen * 2;

			while (!st1.isEmpty()) {
				int v = st1.peek()[1];
				if (v <= tmp) {
					st1.pop();
					tmp -= v;
				} else {
					int[] a = st1.pop();
					int b = a[0];
					int c = a[1];

					c -= tmp;

					st1.push(new int[] {b, c});
					break;
				}

			}

			tmp = cap;

			while(!st2.isEmpty()) {
				int v =st2.peek()[1];
				if(v <= tmp) {
					st2.pop();
					tmp -= v;
				} else {
					int[] a = st2.pop();
					int b = a[0];
					int c = a[1];

					c -= tmp;

					st2.push(new int[]{b, c});
					break;
				}
			}
		}
		return answer;
	}
}
