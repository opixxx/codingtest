package Baekjoon;

import java.util.Scanner;

public class _1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(pow(A, B, C));


    }

    static long pow(int A, int B, int C) {
        if (B == 1) {
            return A % C;
        } else {
            long n = pow(A, B / 2, C);

            if (B % 2 == 1) {
                return (n * n % C) * A % C;
            }
            return n * n % C;
        }

    }
}
