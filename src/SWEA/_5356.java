package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class _5356 {
    static char[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        for (int tc = 1; tc <= test; tc++) {
            String answer = "";
            board = new char[5][15];
            for (char[] chars : board) {
                Arrays.fill(chars, '.');
            }

            for (int i = 0; i < 5; i++) {
                String str = sc.next();
                for (int j = 0; j < str.length() ; j++) {
                    board[i][j] = str.charAt(j);
                }
            }
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 5; j++) {
                    answer += board[j][i];
                }
            }

            String result = answer.replace(".", "");

            System.out.println("#" + tc + " " + result);

        }


    }
}
