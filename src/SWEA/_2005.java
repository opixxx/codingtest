package SWEA;

import java.util.Scanner;

public class _2005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t = 1; t <= test ; t++) {
            int n = sc.nextInt();
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (i == j) map[i][j] = 1;
                    if (j == 0) {
                        map[i][j] = 1;
                    } else {
                        map[i][j] = map[i - 1][j - 1] + map[i - 1][j];
                    }
                }
            }
            System.out.println("#" + t);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
