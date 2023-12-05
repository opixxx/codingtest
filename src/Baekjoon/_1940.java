package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class _1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int left = 0;
        int right = n - 1;
        int count = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        while (left < right) {
            if (arr[left] + arr[right] > m) {
                right--;
            }
            else if (arr[left] + arr[right] < m) {
                left++;
            } else {
                count++;
                left++;
                right--;
            }
        }
        System.out.println(count);

    }


}
