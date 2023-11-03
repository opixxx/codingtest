package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class _1986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int t = 1; t <= test; t++) {
            int n = sc.nextInt();

            int[] num = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    num[i] = - i;
                } else {
                    num[i] = i;
                }
            }
            int sum = Arrays.stream(num).sum();
            System.out.println("#" + t +" " + sum);
        }
       // sc.close();
    }
}
