package SWEA;

import java.util.Scanner;

public class _3431 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            int answer = Integer.MAX_VALUE;
            int[] time = new int[3];
            for (int i = 0; i < time.length; i++) {
                time[i] = sc.nextInt();

            }
            if (time[2] > time[1]) {
                answer = -1;
            }
            if (time[2] <= time[1] && time[2] >= time[0]) {
                answer = 0;
            }
            if (time[2] < time[0]) {
                answer = time[0] - time[2];
            }

            System.out.println("#" + tc + " " + answer);

        }

    }
}
