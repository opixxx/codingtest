package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _30701 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long N = Long.parseLong(st.nextToken());
		long D = Long.parseLong(st.nextToken());

		PriorityQueue<Long> monster = new PriorityQueue<>();
		PriorityQueue<Long> item = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			long x = Long.parseLong(st.nextToken());

			if (type == 1) {
				monster.offer(x);
			} else {
				item.offer(x);
			}
		}
		long ans = item.size();

		while (!monster.isEmpty()) {

			while (!item.isEmpty() && monster.peek() >= D) {
				D *= item.poll();
			}

			if (!monster.isEmpty() && monster.peek() < D) {
				D += monster.poll();
				ans++;
			} else {
				break;
			}
		}

		System.out.println(ans);
	}
}
