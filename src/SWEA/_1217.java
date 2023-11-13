package SWEA;

import java.util.Scanner;

public class _1217 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int test = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();

            System.out.println("#" + tc + " " + sol(n, m));
        }
    }

    private static int sol(int n, int m) {
        int answer = 1;
        for (int i = 0; i < m; i++) {
            answer = answer * n;
        }
        return answer;
    }
}
