package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 주사위_고르기 {
	static int n, win, aWin;
	static int[][] arr;
	static boolean[] visited;
	static int[] aDice, bDice;
	static List<Integer> aSum, bSum;
	static int[] answer;
	public int[] solution(int[][] dice) {
		arr = dice;
		n = dice.length;
		answer = new int[n / 2];
		visited = new boolean[n];
		combi(0, 0);

		return answer;
	}

	public void combi(int depth, int s) {
		if(depth == n / 2) {
			aWin = 0;
			check();
			if (aWin > win) {
				for (int i = 0; i < n / 2; i++) {
					answer[i] = aDice[i] + 1;
				}
				win = aWin;
			}
		} else {
			for (int i = s; i < n; i++) {
				visited[i] = true;
				combi(depth + 1, i + 1);
				visited[i] = false;
			}
		}

	}

	public void check() {
		aDice = new int[n / 2];
		bDice = new int[n / 2];

		int aSize = 0, bSize = 0;

		for (int i = 0; i < n; i++) {
			if(visited[i]) aDice[aSize++] = i;
			else bDice[bSize++] = i;
		}

		aSum = new ArrayList<>();
		bSum = new ArrayList<>();

		getSum(0, 0, aDice, aSum);
		getSum(0, 0, bDice, bSum);

		getResult(aSum, bSum);

	}

	public void getSum(int L, int sum, int[] now, List<Integer> sumList) {
		if (L == n / 2) {
			sumList.add(sum);
			return;
		}

		for (int i = 0; i < 6; i++) {
			getSum(L + 1, sum + arr[now[L]][i], now, sumList);
		}
	}

	public void getResult(List<Integer> aSum, List<Integer> bSum) {

		Collections.sort(bSum);
		for (Integer a : aSum) {
			aWin += binary(a);
		}
	}

	public int binary(int target) {
		int lt = 0;
		int rt = bSum.size() - 1;

		while(lt <= rt) {
			int mid =(lt + rt) / 2;

			if (bSum.get(mid) < target) {
				lt = mid + 1;
			} else {
				rt = mid - 1;
			}
		}
		return lt;
	}
}