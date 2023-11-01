package SWEA;

import java.util.Scanner;

public class _1946 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = sc.nextInt();
            char[] c = new char[n];
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                c[i] = sc.next().charAt(0);
                num[i] = sc.nextInt();

            }
            int cnt = 0;
            System.out.println("#" + t);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < num[i]; j++) {
                    System.out.print(c[i]);
                    cnt++;
                    if (cnt == 10) {
                        System.out.println();
                        cnt = 0;
                    }
                }
            }
            System.out.println();
        }
    }

}
