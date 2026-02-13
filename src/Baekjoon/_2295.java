package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2295 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				list.add(arr[i] + arr[j]);
			}
		}
		Collections.sort(list);

		int[] sumValue = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			sumValue[i] = list.get(i);
		}
		int answer = -1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (binarySearch(sumValue, arr[i] - arr[j])) {
					answer = Math.max(answer, arr[i]);
				}
			}
		}

		System.out.println(answer);

	}

	static boolean binarySearch(int[] sumValue, int target) {
		int l = 0;
		int r = sumValue.length;

		while (l < r) {
			int mid = (l + r) >>> 1;
			if(sumValue[mid] >= target) r = mid;
			else l = mid + 1;
		}
		return l < sumValue.length && sumValue[l] == target;
	}
}
