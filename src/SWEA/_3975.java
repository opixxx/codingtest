package SWEA;

import java.util.Scanner;

public class _3975 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int D = sc.nextInt();
            double alice = A / (double) B;
            double bob = C / (double) D;
            System.out.print("#" + tc + " ");
            if (alice > bob) {
                System.out.print("ALICE");

            } else if (alice < bob) {
                System.out.print("BOB");
            } else {
                System.out.print("DRAW");
            }
            System.out.println();
        }
    }
}
