package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2885 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		char[] binaryArr = Integer.toBinaryString(n).toCharArray();
		int a = 0; //초콜릿 크기
		int b = 0; //자르는 횟수
		if ((n & (n - 1)) == 0) {
			a = n;
			b = 0;
		} else {
			for (int i = binaryArr.length - 1; i >= 0; i--) {
				if (binaryArr[i] == '1') {
					if (i == binaryArr.length - 1) {
						b = binaryArr.length;
						a = (int) Math.pow(2, binaryArr.length);
					} else {
						b = i + 1;
						a = (int) Math.pow(2, binaryArr.length);
					}
					break;
				}
			}

		}
		System.out.println(a + " " + b);
	}
}
