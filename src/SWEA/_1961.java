package SWEA;

import java.util.Scanner;

public class _1961 {
    static int n;
    static int[][] num;
    public static int[][] rotate90Degree(int[][] arr) {
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = arr[n - 1 - j][i];
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            n = sc.nextInt();
            num = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    num[i][j] = sc.nextInt();
                }
            }

            int[][] degree90 = rotate90Degree(num);
            int[][] degree180 = rotate90Degree(degree90);
            int[][] degree270 = rotate90Degree(degree180);
            System.out.println("#" + t);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(degree90[i][j]);
                }
                System.out.print(" ");

                for (int j = 0; j < n; j++) {
                    System.out.print(degree180[i][j]);
                }
                System.out.print(" ");

                for (int j = 0; j < n; j++) {
                    System.out.print(degree270[i][j]);
                }
                System.out.println(" ");
            }
        }
    }
}
