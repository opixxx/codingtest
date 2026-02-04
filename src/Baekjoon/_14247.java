package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14247 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		long answer = 0;
		for (int i = 0; i < n; i++) {
			answer += Integer.parseInt(st.nextToken());
		}

		int[] grow = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			grow[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(grow);

		for (int i = 0; i < n; i++) {
			answer = answer + (grow[i] * i);
		}

		System.out.println(answer);
	}
}
