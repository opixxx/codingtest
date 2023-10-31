package SWEA;

import java.util.Scanner;

public class _1204 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        for (int i = 1; i <= test; i++) {
            int[] score = new int[101];

            sc.nextInt();

            for (int j = 0; j < 1000; j++) {
                int num = sc.nextInt();
                score[num]++;
            }

            int maxCount = 0;
            int maxScore= 0;
            for (int j = 0; j < 101; j++) {
                if (score[j] >= maxCount) {
                    maxCount = score[j];
                    maxScore = j;
                }
            }

            System.out.println("#" + i + " " + maxScore);

        }
    }
}
