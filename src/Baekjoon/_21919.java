package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _21919 {
	static Set<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		list = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (isPrime(arr[i])) {
				list.add(arr[i]);
			}
		}

		if (list.isEmpty()) {
			System.out.println(-1);

		} else {
			long answer = 1;

			for (int integer : list) {
				answer *= integer;
			}
			System.out.println(answer);
		}
	}

	static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		if (num == 2) {
			return true;
		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
