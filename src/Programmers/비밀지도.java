package Programmers;

public class 비밀지도 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		//두 지도에서 하나라도 벽(#) 이면 벽 1
		//두 지도에서 모두 공백인 부분은 공백 0

		for (int i = 0; i < arr1.length; i++) {
			String result = Integer.toBinaryString(arr1[i] | arr2[i]);
			String change = change(n, result);

			answer[i] = change;
		}
		return answer;
	}
	static String change(int n, String binary) {
		String str = " ".repeat(n - binary.length()) + binary;
		str = str.replaceAll("0", " ");
		str = str.replaceAll("1", "#");
		return str;
	}
}
