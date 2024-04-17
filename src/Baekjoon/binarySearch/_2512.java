package Baekjoon.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class _2512 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long answer = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long limit = sc.nextLong();

        Arrays.sort(arr);

        long left = 0;
        long right = arr[n - 1];

        while (left <= right) {
            long sum = 0;
            long mid = (left + right) / 2;
            for (int money : arr) {
                if (money >= mid) {
                    sum += mid;
                } else {
                    sum += money;
                }
            }
            if (sum > limit) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = Math.max(answer, mid);
            }
        }

        System.out.println(answer);
    }
}
