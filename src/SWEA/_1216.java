package SWEA;

import java.util.Scanner;

public class _1216 {
    static int max;
    public static void palindrome(String input) {
        String tmp = new StringBuilder(input).reverse().toString();
        if (input.equals(tmp)) {
            max = Math.max(max, input.length());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int test = sc.nextInt();
            char[][] board = new char[100][100];

            for (int i = 0; i < 100; i++) {
                String str = sc.next();
                board[i] = str.toCharArray();
            }

            max = 1;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    for (int k = j + 1; k <= 100; k++) {
                        palindrome(new String(board[i], j, k - j));
                    }
                }
            }

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    for (int k = j + 1; k <= 100; k++) {
                        StringBuilder column = new StringBuilder();
                        for (int l = j; l < k; l++) {
                            column.append(board[l][i]);
                        }
                        palindrome(column.toString());
                    }
                }
            }

            System.out.println("#" + tc + " " + max);

        }

    }
}
