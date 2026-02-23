package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _3151 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Arrays.sort(arr);

		long answer = 0;
		for (int i = 0; i < n; i++) {
			int l = i + 1;
			int r = n - 1;
			while (l < r) {
				int sum =arr[i] + arr[l] + arr[r];
				if (sum == 0) {
					if (arr[l] == arr[r]) {
						int cnt = r - l + 1;
						answer += (long)cnt * (cnt - 1) / 2;
						break;
					} else {
						int left = arr[l];
						int right = arr[r];

						int leftCnt = 0;
						int rightCnt = 0;
						while (l < r && arr[l] == left) {
							leftCnt++;
							l++;
						}
						while (l <= r && arr[r] == right) {
							rightCnt++;
							r--;
						}
						answer += (long)leftCnt * rightCnt;
					}
				} else if (sum < 0) {
					l++;
				} else {
					r--;
				}

			}
		}
		System.out.println(answer);
	}
}
