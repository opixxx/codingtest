package SWEA;

import java.util.Scanner;

public class _2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for (int i = 1; i <= test; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] bug = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    bug[j][k] = sc.nextInt();
                }
            }

            int max = 0;
            for (int j = 0; j <= n - m; j++) {
                for (int k = 0; k <= n - m; k++) {
                    int sum = 0;
                    for (int l = 0; l < m; l++) {
                        for (int o = 0; o < m; o++) {
                            sum += bug[j + l][k + o];
                        }
                    }
                    if (sum > max) {
                        max = sum;
                    }

                }

            }
            System.out.println("#" + i + " " + max);


        }
    }
}
