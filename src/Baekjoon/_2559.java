package Baekjoon;

import java.util.Scanner;

public class _2559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] psum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            psum[i] = psum[i - 1] + sc.nextInt();
        }
        int answer = Integer.MIN_VALUE;
        for (int i = k; i <= n; i++) {
            answer = Math.max(answer, psum[i] - psum[i - k]);
        }
        System.out.println(answer);
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i <= n - k; i++) {
//            int sum = 0;
//            for (int j = i; j <= i + k - 1; j++) {
//                sum += arr[j];
//            }
//            max = Math.max(sum, max);
//        }
//
//        System.out.println(max);

    }
}
