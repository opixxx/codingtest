package Programmers;

import java.util.ArrayList;
import java.util.List;

public class 양과_늑대  {
	static List<List<Integer>> list = new ArrayList<>();
	static int answer = 0;
	static int[] infoArr;
	public int solution(int[] info, int[][] edges) {

		infoArr = info;

		for (int i = 0; i < info.length; i++) {
			list.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			list.get(edge[0]).add(edge[1]);
		}

		List<Integer> notVisited = new ArrayList<>();
		notVisited.add(0);

		dfs(0, notVisited, 0, 0);
		return answer;
	}

	void dfs(int node, List<Integer> notVisited, int lamp, int wolf) {
		if(infoArr[node] == 0) lamp++;
		else wolf++;

		if(wolf >= lamp) return;
		answer = Math.max(answer, lamp);

		List<Integer> next = new ArrayList<>(notVisited);
		if(!list.isEmpty()) {
			next.addAll(list.get(node));
		}

		next.remove(Integer.valueOf(node));

		for (int n : next) {
			dfs(n, next, lamp, wolf);
		}
	}
}
