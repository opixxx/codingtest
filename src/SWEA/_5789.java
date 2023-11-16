package SWEA;

import java.util.Scanner;

public class _5789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] box = new int[n + 1];
            for (int i = 1; i <= q; i++) {
                int l = sc.nextInt();
                int r = sc.nextInt();

                for (int j = l; j <= r; j++) {
                    box[j] = i;
                }
            }
            System.out.print("#" + tc + " ");
            for (int i = 1; i < box.length; i++) {
                System.out.print(box[i]);
                if (i < box.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
