package SWEA;

import java.util.Scanner;

public class _10726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            String answer = "ON";
            int n = sc.nextInt();
            int m = sc.nextInt();
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (m % 2 == 0) {
                    flag = true; // n 비트가 하나라도 0이다
                }
                m = m / 2;
            }
            // true -> n 비트 모두 1이 아니다  flase -> n 비트 모두 1
            if (flag) {
                answer = "OFF";

            }
            System.out.println("#" + tc + " " + answer);
        }
        sc.close();
    }
}
