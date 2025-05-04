package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2531 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] sushi = new int[n];
		int[] selected = new int[d + 1];

		for (int i = 0; i < n; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		selected[c] = 1;
		int cnt = 1;


		for (int i = 0; i < k; i++) {
			if (selected[sushi[i]] == 0) {
				cnt++;
			}
			selected[sushi[i]]++;
		}

		int max = cnt;

		for (int i = 1; i < n; i++) {
			selected[sushi[i-1]]--;
			if (selected[sushi[i - 1]] == 0) {
				cnt--;
			}
			if (selected[sushi[(i + k - 1) % n]] == 0) {
				cnt++;
			}
			selected[sushi[(i+k-1) % n]]++;

			max = Math.max(max, cnt);
		}

		System.out.println(max);
	}
}
