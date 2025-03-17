package Programmers;

import java.util.Arrays;

public class 양궁대회  {
	static int max = Integer.MIN_VALUE;
	static int[] score = new int[11];
	static int[] answer = {-1};
	public int[] solution(int n, int[] info) {

		dfs(0, n, info);
		if (max == -1) {
			answer = new int[1];
			answer[0] = -1;
		}

		return answer;
	}
	static void dfs(int depth, int n, int[] info) {
		if (depth == n) {
			int diff = getAnswer(info);
			if (diff >= max) {
				max = diff;
				answer = Arrays.copyOf(score, score.length);
			}
			return;
		}

		for (int i = 0; i < info.length && score[i] <= info[i]; i++) {
			score[i] += 1;
			dfs(depth + 1, n, info);
			score[i] -= 1;
		}
	}

	static int getAnswer(int[] info) {
		int apeach = 0;
		int lion = 0;

		for (int i = 0; i < score.length; i++) {
			int apeachScore = info[i];
			int lionScore = score[i];
			if (apeachScore == 0 && lionScore == 0) continue;
			if (lionScore > apeachScore) {
				lion += 10 - i;
			} else {
				apeach += 10 - i;
			}
		}
		int diff = lion - apeach;
		if (diff <= 0) return -1;
		return diff;
	}
}
