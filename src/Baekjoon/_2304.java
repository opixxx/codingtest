package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _2304 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Node[] arr = new Node[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			arr[i] = new Node(x, h);
		}

		Arrays.sort(arr, Comparator.comparingInt(a -> a.x));
		int maxIdx = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i].h > arr[maxIdx].h) {
				maxIdx = i;
			}
		}

		long area = 0;

		int curH = arr[0].h;
		int curX = arr[0].x;

		for (int i = 1; i <= maxIdx; i++) {
			if (arr[i].h >= curH) {
				area += (long)(arr[i].x - curX) * curH;
				curX = arr[i].x;
				curH = arr[i].h;
			}
		}

		curH = arr[n - 1].h;
		curX = arr[n - 1].x;

		for (int i = n - 2; i >= maxIdx; i--) {
			if (arr[i].h >= curH) {
				area += (long)(curX - arr[i].x) * curH;
				curX = arr[i].x;
				curH = arr[i].h;
			}
		}

		area += arr[maxIdx].h;

		System.out.println(area);

	}

	static class Node {
		int x;
		int h;

		public Node(int x, int h) {
			this.x = x;
			this.h = h;
		}
	}
}
