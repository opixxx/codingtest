package Baekjoon.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class _15810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        long left = 0;
        long right = (long) arr[n - 1] * m;

        while (left <= right) {
            long count = 0;
            long mid = (left + right) / 2;

            for (int minute : arr) {
                count += mid / (long) minute;
            }
            if (count >= m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);

    }
}
