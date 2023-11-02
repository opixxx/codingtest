package SWEA;

import java.util.Scanner;

public class _1970 {
    static int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int t = 1; t <= test; t++) {
            int[] answer = new int[8];

            int n = sc.nextInt(); //현재돈
            for (int i = 0; i < 8; i++) {
                if (n / money[i] >= 1) {
                    answer[i] = n / money[i];
                    n = n - money[i] * (n / money[i]);
                }
            }
            System.out.println("#" + t);
            for (int change : answer) {
                System.out.print(change + " ");
            }
            System.out.println();
        }

    }
}
