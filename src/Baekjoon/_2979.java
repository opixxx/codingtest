package Baekjoon;

import java.util.Scanner;

public class _2979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int[] time = new int[100];
        int sum = 0;


        for (int i = 0; i < 3; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            for (int j = start; j < end; j++) {
                time[j]++;
            }
        }

        for (int j : time) {
            if (j == 1) {
                sum += A;
            } else if (j == 2) {
                sum += B * 2;
            } else if (j == 3) {
                sum += C * 3;
            }

        }
        System.out.println(sum);

    }
}
