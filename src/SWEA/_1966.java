package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class _1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = sc.nextInt();
            Integer[] num = new Integer[n];
            for (int i = 0; i < n; i++) {
                num[i] = sc.nextInt();
            }
            Arrays.sort(num);
            System.out.print("#" + t + " ");
            for (Integer a : num) {
                System.out.print(a + " ");
            }
            System.out.println();
        }

    }
}
