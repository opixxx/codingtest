package Baekjoon;

import java.util.Scanner;

public class _14890 {
    static int n, l;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        l = sc.nextInt();

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (carRow(i)) count++;
            if (carCol(i)) count++;
        }
        System.out.println(count);


    }
    private static boolean carRow(int row) {
        boolean[] isIncline = new boolean[n];
        for (int i = 0; i < n - 1; i++) {
            int diff = arr[row][i] - arr[row][i + 1];

            if (diff > 1 || diff < -1) return false;
            // 다음 블록이 더 높은 경우
            else if (diff == -1) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || isIncline[i - j]) return false;

                    if (arr[row][i] != arr[row][i - j]) return false;
                    isIncline[i - j] = true;
                }
            } else if (diff == 1) {
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || isIncline[i + j]) return false;
                    if (arr[row][i] - 1 != arr[row][i + j]) return false;
                    isIncline[i + j] = true;
                }
            }
        }
        return true;
    }

    private static boolean carCol(int col) {
        boolean[] isIncline = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int diff = arr[i][col] - arr[i + 1][col];

            if (diff > 1 || diff < -1) return false;
            else if (diff == -1) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || isIncline[i - j]) return false;

                    if (arr[i][col] != arr[i - j][col]) return false;
                    isIncline[i - j] = true;
                }
            } else if (diff == 1) {
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || isIncline[i + j]) return false;
                    if (arr[i][col] - 1 != arr[i + j][col]) return false;
                    isIncline[i + j] = true;
                }
            }
        }
        return true;
    }
}
