package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _1822 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int nA = Integer.parseInt(st.nextToken());
		int nB = Integer.parseInt(st.nextToken());

		int[] arrA = new int[nA];
		int[] arrB = new int[nB];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nA; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nB; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrB);

		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < nA; i++) {
			int target = arrA[i];

			if (!binarySearch(arrB, target)) {
				answer.add(target);
			}
		}

		Collections.sort(answer);

		System.out.println(answer.size());
		if (!answer.isEmpty()) {
			for (Integer i : answer) {
				System.out.print(i + " ");
			}
		}
	}

	static boolean binarySearch(int[] arr, int target) {
		int l = 0;
		int r = arr.length;

		while (l < r) {
			int mid = (l + r) >>> 1;
			if (arr[mid] == target) return true;
			if (arr[mid] > target) r = mid;
			else l = mid + 1;
		}

		return false;
	}
}
