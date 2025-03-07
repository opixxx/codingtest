package Programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class 주차_요금_계산 {
	static List<Pair> in;
	static List<Pair> out;
	static final int LAST_TIME = 1439;
	public int[] solution(int[] fees, String[] records) {

		int a = fees[0]; // 기본시간
		int b = fees[1]; // 기본요금
		int c = fees[2]; // 단위시간
		int d = fees[3]; // 단위요금
		in = new ArrayList<>();
		out = new ArrayList<>();

		TreeMap<String, Integer> map = new TreeMap<>();

		for(String str : records) {
			String[] tmp = str.split(" ");
			String time = tmp[0];
			String carNum = tmp[1];
			String inOut = tmp[2];

			int changeTime = changeMin(time);


			if (inOut.equals("IN")) {
				in.add(new Pair(changeTime, carNum));
			} else if (inOut.equals("OUT")) {
				out.add(new Pair(changeTime, carNum));
			}
		}

		boolean[] inCheck = new boolean[in.size()];
		boolean[] outCheck = new boolean[out.size()];

		for (int i = 0; i < in.size(); i++) {
			var inData = in.get(i);

			for (int j = 0; j < out.size(); j++) {
				var outData = out.get(j);
				if (!outCheck[j] && !inCheck[i] && inData.carNum.equals(outData.carNum)) {
					inCheck[i] = true;
					outCheck[j] = true;
					int minusTime = outData.time - inData.time;
					map.put(inData.carNum, map.getOrDefault(inData.carNum, 0) + minusTime);
				}
			}
		}

		for (int i = 0; i < in.size(); i++) {
			if(!inCheck[i]) {
				var inData = in.get(i);
				int minusTime = LAST_TIME - inData.time;

				map.put(inData.carNum, map.getOrDefault(inData.carNum, 0) + minusTime);
			}
		}
		List<Integer> result = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			int value = entry.getValue();
			if (value <= a) {
				result.add(b);
				continue;
			}

			int f = (value - a) % c;
			int g = (value - a) / c;
			if (f != 0) g += 1;
			result.add(b + (g * d));
		}

		return result.stream().mapToInt(Integer::intValue).toArray();
	}


	public int changeMin(String time) {
		String[] tmp = time.split(":");
		int hour = Integer.parseInt(tmp[0]);
		int min = Integer.parseInt(tmp[1]);

		hour = hour * 60;

		return hour + min;

	}

	static class Pair {
		int time;
		String carNum;

		public Pair(int time, String carNum) {
			this.time = time;
			this.carNum = carNum;
		}
	}
}