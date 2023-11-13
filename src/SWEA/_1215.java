package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int len = Integer.parseInt(br.readLine());
            char[][] board = new char[8][8];
            for (int i = 0; i < 8; i++) {
                String str = br.readLine();
                for (int j = 0; j < 8; j++) {
                    board[i][j] = str.charAt(j);
                }
            }
            int count = 0;
            for (int i = 0; i < 8; i++) {
                StringBuffer rowSb = new StringBuffer();
                for (int j = 0; j < 8; j++) {
                    rowSb.append(board[i][j]);
                    if (rowSb.length() > len) {
                        rowSb.delete(0, 1);
                    }
                    if (rowSb.length() == len && palindrome(rowSb)) {
                        count++;
                    }

                }
            }
            for (int i = 0; i < 8; i++) {
                StringBuffer colSb = new StringBuffer();
                for (int j = 0; j < 8; j++) {
                    colSb.append(board[j][i]);
                    if (colSb.length() > len) {
                        colSb.delete(0, 1);
                    }
                    if (colSb.length() == len && palindrome(colSb)) {
                        count++;
                    }
                }
            }
            System.out.println("#" + tc + " " + count);
        }

    }
    public static boolean palindrome(StringBuffer sb) {
        String str1 = sb.toString();
        String str2 = sb.reverse().toString();
        sb.reverse();
        return str1.equals(str2);
    }
}
