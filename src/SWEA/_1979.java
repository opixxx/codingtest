package SWEA;


import java.util.Scanner;

public class _1979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] board = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            int cnt = 0;
            int result = 0;
            // 행검사
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1) {
                        cnt++;
                    } else if (board[i][j] == 0) {
                        if (cnt == k){
                            result++;
                            cnt = 0;
                        } else cnt = 0;
                    }
                }
                if (cnt == k) {
                    result++;
                    cnt = 0;
                } else cnt = 0;

            }
            //열검사
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    if (board[i][j] == 1) {
                        cnt++;
                    } else if (board[i][j] == 0) {
                        if (cnt == k){
                            result++;
                            cnt = 0;
                        } else cnt = 0;
                    }
                }
                if (cnt == k) {
                    result++;
                    cnt = 0;
                } else cnt = 0;
            }
            System.out.println("#" + t + " " + result);
        }
    }
}
