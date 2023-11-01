package SWEA;

import java.util.Scanner;

public class _1974 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for (int i = 1; i <= test; i++) {
            boolean sign = true;
            int[][] board = new int[9][9];
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    board[j][k] = sc.nextInt();
                }
            }
            //행체크
            for (int j = 0; j < 9; j++) {
                int[] ch = new int[9];
                for (int k = 0; k < 9; k++) {
                    ch[board[j][k] - 1]++;
                }
                for (int k = 0; k < 9; k++) {
                    if (ch[k] == 0) {
                        sign = false;
                        break;
                    }
                }
            }
            //열체크
            for (int j = 0; j < 9; j++) {
                int[] ch = new int[9];
                for (int k = 0; k < 9; k++) {
                    ch[board[k][j] - 1]++;
                }
                for (int k = 0; k < 9; k++) {
                    if (ch[k] == 0) {
                        sign = false;
                        break;
                    }
                }
            }
            
            //격자체크
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int[] ch = new int[9];
                    for (int r = 0; r < 3; r++) {
                        for (int c = 0; c < 3; c++) {
                            ch[board[j * 3 + r][k * 3 + c] - 1]++;
                        }
                    }
                    for (int l = 0; l < 9; l++) {
                        if (ch[l] == 0) {
                            sign = false;
                            break;
                        }
                    }
                }
            }

            if (sign) {
                System.out.println("#" + i + " " + 1);
            } else {
                System.out.println("#" + i + " " + 0);
            }
        }
    }
}
