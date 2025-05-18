package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _4408 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int[] arr = new int[201];
			int n = Integer.parseInt(br.readLine());

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int a = (Integer.parseInt(st.nextToken()) + 1) / 2;
				int b = (Integer.parseInt(st.nextToken()) + 1) / 2;

				if (a < b) {
					for (int j = a; j <= b; j++) {
						arr[j]++;
					}
				} else {
					for (int j = b; j <= a; j++) {
						arr[j]++;
					}
				}
			}
			Arrays.sort(arr);
			sb.append("#").append(t).append(" ").append(arr[200]).append("\n");
		}
		System.out.println(sb);
	}
}