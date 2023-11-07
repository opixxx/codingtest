package SWEA;

import java.util.Scanner;

public class _2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = sc.nextInt();
            int mid = n / 2;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                String str = sc.next();
                if (i <= mid) {
                    for (int j = mid - i; j < mid + i + 1; j++) {
                        sum += str.charAt(j) - '0';
                    }
                } else {
                    for (int j = i - mid; j < n + mid - i; j++) {
                        sum += str.charAt(j) - '0';
                    }
                }
            }
            System.out.println("#" + t + " " + sum);

        }
    }
}
