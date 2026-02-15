package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _16401 {
	static int[] snack;
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		snack = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			snack[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(snack);

		System.out.println(binarySearch());
	}

	static int binarySearch() {
		int l = 1;
		int r = snack[snack.length - 1] + 1;

		while (l < r) {
			int mid = (l + r) >>> 1;
			int tmp = getValue(mid); // mid(과자 길이) 값으로 조카들에게 나눠줄 수 있는 과자의 갯수
			if (tmp < m) { // mid 값으로 조카들에게 과자를 나눠줄 수 없다. -> mid(과자 길이)를 줄여야한다.
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l - 1;
	}

	static int getValue(int mid) {
		int result = 0;
		for (int i = 0; i < snack.length; i++) {
			result += snack[i] / mid;
		}

		return result;
	}
}

