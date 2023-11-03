package SWEA;

import java.util.Scanner;

public class _1959 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }
            int max = Integer.MIN_VALUE;
            if (m > n) {
                for (int i = 0; i < m - n + 1; i++) {
                    int sum = 0;
                    for (int j = 0; j < n; j++) {
                        sum += a[j] * b[i + j];
                    }
                    max = Math.max(max, sum);
                }
            }
            else if (n > m) {
                for (int i = 0; i < n - m + 1; i++) {
                    int sum = 0;
                    for (int j = 0; j < m; j++) {
                        sum += a[i + j] * b[j];
                    }
                    max = Math.max(max, sum);
                }
            } else {
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += a[i] * b[i];
                }
                max = sum;
            }
            System.out.println("#" + t + " " + max);

        }
    }
}
