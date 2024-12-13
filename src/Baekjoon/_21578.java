package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21578 {
    static int[] arr;
    static long[] prefixSum;
    static long[] prefixSum1;
    static int n;
    static long answer = Long.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        prefixSum = new long[n];
        prefixSum1 = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        prefixSum[0] = arr[0];
        prefixSum1[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
            prefixSum1[n - 1 - i] = prefixSum1[n - i] + arr[n - 1 - i];
        }

        for (int i = 1; i < n - 1; i++) {
            answer = Math.max(answer, prefixSum[i] - prefixSum[0] + prefixSum1[i] - prefixSum1[n - 1]);
            answer = Math.max(answer, prefixSum[n - 1] - prefixSum[0] - arr[i] + prefixSum[n - 1] - prefixSum[i]);
            answer = Math.max(answer, prefixSum1[0] - prefixSum1[n - 1] - arr[i] + prefixSum1[0] - prefixSum1[i]);
        }
        System.out.println(answer);
    }
}
