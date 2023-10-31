package SWEA;

import java.util.Scanner;

public class _1859 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        for (int i = 1; i <= test; i++) {

            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }

            int max = 0;
            int sum = 0;

            for (int j = n - 1; j >= 0; j--) {
                if (arr[j] > max) {
                    max = arr[j];
                }

                if (arr[j] < max) {
                    sum += max - arr[j];
                }
            }

            System.out.println("#" + i + " " + sum);

        }
    }
}
