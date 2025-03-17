package Programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class 두_큐_합_같게_만들기 {
	public int solution(int[] queue1, int[] queue2) {
		int answer = 0;

		Queue<Integer> q1 = new ArrayDeque<>();
		Queue<Integer> q2 = new ArrayDeque<>();

		long checkSum = 0;

		long qSum1 = 0;
		long qSum2 = 0;
		for (int i = 0; i < queue1.length; i++) {
			q1.offer(queue1[i]);
			checkSum += queue1[i];
			qSum1 += queue1[i];
		}

		for (int i = 0; i < queue2.length; i++) {
			q2.offer(queue2[i]);
			checkSum += queue2[i];
			qSum2 += queue2[i];
		}

		if (checkSum % 2 != 0) {
			return answer -1;
		}

		int maxMove = (queue1.length + queue2.length) * 2;

		while (true) {
			if (answer > maxMove) {
				answer = -1;
				break;
			}
			if (q1.isEmpty() || q2.isEmpty()) {
				answer = -1;
				break;
			}

			if (qSum1 == qSum2) {
				break;
			}

			else if (qSum1 > qSum2) {
				int poll1 = q1.poll();
				qSum1 -= poll1;
				q2.offer(poll1);
				qSum2 += poll1;
			} else {

				int poll2 = q2.poll();
				qSum2 -= poll2;
				q1.offer(poll2);
				qSum1 += poll2;
			}
			answer++;
		}
		return answer;
	}
}
