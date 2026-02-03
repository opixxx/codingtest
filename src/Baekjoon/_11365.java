package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11365 {
	public static void main(String[] args) throws IOException {

		StringBuilder answer = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String a = br.readLine();

			if (a.equals("END")){
				break;
			}
			answer.append(new StringBuilder(a).reverse().append("\n"));
		}
		System.out.println(answer);
	}
}
