package SWEA;

import java.util.Scanner;

public class _1206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            int apart = sc.nextInt();
            int[] floor = new int[apart];
            for (int i = 0; i < apart; i++) {
                floor[i] = sc.nextInt();
            }
            int sum = 0;
            for (int i = 2; i < apart - 2; i++) {
                if (floor[i] > floor[i + 1] && floor[i] > floor[i + 2] &&
                        floor[i] > floor[i - 1] && floor[i] > floor[i - 2]) {
                    int right1 = floor[i] - floor[i + 1];
                    int right2 = floor[i] - floor[i + 2];
                    int left1 = floor[i] - floor[i - 1];
                    int left2 = floor[i] - floor[i - 2];
                    int rightMin = Math.min(right2, right1);
                    int leftMin = Math.min(left2, left1);
                    sum += Math.min(rightMin, leftMin);
                }
            }
            System.out.println("#" + t + " " + sum);
        }
    }
}
