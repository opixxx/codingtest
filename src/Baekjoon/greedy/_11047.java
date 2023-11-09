package Baekjoon.greedy;

import java.util.Scanner;

public class _11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coin = new int[n];
        int cnt = 0;
        for (int i = 0; i < coin.length; i++) {
            coin[i] = sc.nextInt();
        }

        for (int i = n - 1; i >= 0; i--) {
            if (k == 0) {
                break;
            } if (coin[i] <= k) {
                cnt = cnt + k / coin[i];
                k = k % coin[i];
            }
        }
        System.out.println(cnt);
    }
}
