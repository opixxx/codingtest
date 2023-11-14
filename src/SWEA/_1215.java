package SWEA;

import java.util.Scanner;

public class _1215 {
    static int len, count;

    public static void palindrome(String input) {
        if (input.length() == len) {
            String tmp = new StringBuilder(input).reverse().toString();
            if (input.equals(tmp)) {
                count++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            count = 0;
            len = sc.nextInt();
            char[][] board = new char[8][8];

            for (int i = 0; i < 8; i++) {
                String str = sc.next();
                board[i] = str.toCharArray();
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - len; j++) {
                    for (int k = j + len; k <= 8; k++) {
                        palindrome(new String(board[i], j, k - j));
                    }
                }
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - len; j++) {
                    for (int k = j + len; k <= 8; k++) {
                        StringBuilder column = new StringBuilder();
                        for (int l = j; l < k; l++) {
                            column.append(board[l][i]);

                        }
                        palindrome(column.toString());
                    }
                }
            }

            System.out.println("#" + tc + " " + count);
        }
    }
}
