package Baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class _11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        answer[0] = arr[0];
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + arr[i];
        }
        int result = Arrays.stream(answer).sum();
        System.out.println(result);

    }
}
