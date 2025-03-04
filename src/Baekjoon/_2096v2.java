package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2096v2 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] max = new int[3];
		int[] min = new int[3];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (i == 0) {
				max[0] = min[0] = a;
				max[1] = min[1] = b;
				max[2] = min[2] = c;
			} else {
				int preMax0 = max[0];
				int preMax1 = max[1];
				int preMax2 = max[2];
				max[0] = a + Math.max(max[0], max[1]);
				max[1] = b + Math.max(preMax0, Math.max(preMax1, preMax2));
				max[2] = c + Math.max(preMax1, preMax2);

				int preMin0 = min[0];
				int preMin1 = min[1];
				int preMin2 = min[2];
				min[0] = a + Math.min(min[0], min[1]);
				min[1] = b + Math.min(preMin0, Math.min(preMin1, preMin2));
				min[2] = c + Math.min(preMin1, preMin2);

			}

		}
		int maxAns = Math.max(max[0], Math.max(max[1], max[2]));
		int minAns = Math.min(min[0], Math.min(min[1], min[2]));
		System.out.print(maxAns + " " + minAns);
	}
}
