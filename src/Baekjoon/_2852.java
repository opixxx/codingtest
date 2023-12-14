package Baekjoon;

import java.util.Scanner;
public class _2852 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] answer = {0, 0};
        int s = 0;
        int time = 0, goalTime = 0;

        for (int i = 0; i < n; i++) {
            int team = sc.nextInt();
            String[] tmp = sc.next().split(":");
            goalTime = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
            if (s > 0)
                answer[0] += goalTime - time;
            if (s < 0) {
                answer[1] += goalTime - time;
            }
            if (team == 1) {
                s++;
            } else {
                s--;
            }
            time = goalTime;
        }

        if (s > 0) {
            answer[0] += 2880 - goalTime;
        }
        if (s < 0) {
            answer[1] += 2880 - goalTime;
        }

        int min1 = answer[0] / 60;
        int sec1 = answer[0] % 60;
        int min2 = answer[1] / 60;
        int sec2 = answer[1] % 60;

        System.out.printf("%02d:%02d\n", min1, sec1);
        System.out.printf("%02d:%02d\n", min2, sec2);
    }
}
