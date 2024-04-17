package Baekjoon.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class _13702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int ml = sc.nextInt();
            arr[i] = ml;
        }
        Arrays.sort(arr);

        long left = 1;
        long right = arr[n - 1];

        while (left <= right) {
            long count = 0;
            long mid = (left + right) / 2;
            for (int ml : arr) {
                count += ml / mid;
            }
            if (count >= k) {
                left = mid + 1;
            } else {
                right = mid - 1;

            }

        }
        System.out.println(right);


    }
}
