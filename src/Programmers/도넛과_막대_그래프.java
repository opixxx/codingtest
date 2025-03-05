package Programmers;

import java.util.ArrayList;
import java.util.List;

public class 도넛과_막대_그래프 {
	static List<List<Integer>> out;
	static List<List<Integer>> in;
	public int[] solution(int[][] edges) {
		//생성 정점, 도넛, 막대, 8자
		int[] answer = new int[4];

		out = new ArrayList<>();
		in = new ArrayList<>();

		int nodeNum = 0;

		for (int[] tmp : edges) {
			nodeNum = Math.max(nodeNum, Math.max(tmp[0], tmp[1]));
		}

		boolean[] ch = new boolean[nodeNum + 1];

		for (int i = 0; i <= nodeNum; i++) {
			out.add(new ArrayList<>());
			in.add(new ArrayList<>());
		}

		for (int[] tmp : edges) {
			int a = tmp[0];
			int b = tmp[1];
			ch[a] = true;
			ch[b] = true;

			out.get(a).add(b);
			in.get(b).add(a);
		}

		int startNode = findStartNode();

		answer[0] = startNode;
		int totalGraph = out.get(startNode).size();

		ch[startNode] = false;

		for (int target : out.get(startNode)) {
			in.get(target).remove(Integer.valueOf(startNode));
		}
		out.get(startNode).clear();

		for (int i = 0; i < out.size(); i++) {
			var outList = out.get(i);
			var inList = in.get(i);

			if(!ch[i]) continue;

			//막대 그래프 정점에서 나가는 간선이 없으면 막대 그래프이다.
			if (outList.isEmpty()) {
				answer[2]++;
				continue;
			}

			//8자 그래프 : 정점에서 나가는 간선, 들어오는 간선의 수가 2개씩이면 도넛 그래프
			if (outList.size() == 2 && inList.size() == 2) {

				answer[3]++;
				continue;
			}
		}
		answer[1] = totalGraph - (answer[2] + answer[3]);

		return answer;
	}

	static int findStartNode() {
		for(int i = 0; i < out.size(); i++) {
			if(out.get(i).size() >= 2 && in.get(i).isEmpty()) {
				return i;
			}

		}
		return -1;
	}
}