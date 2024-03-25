package Baekjoon.implementation;

import java.io.IOException;
import java.util.Scanner;

public class _2578 {

    static int[][] bingo = new int[5][5];
    static boolean[] rowBingo = new boolean[5];
    static boolean[] colBingo = new boolean[5];
    static boolean[] diagBingo = new boolean[2];
    static int count = 0;


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = sc.nextInt();
            }
        }


        int answer = 0;

        for (int i = 0; i < 25; i++) {
            int value = sc.nextInt();
            answer++;

            for (int k = 0; k < 5; k++) {
                for (int l = 0; l < 5; l++) {
                    if (bingo[k][l] == value) {
                        bingo[k][l] = 0;

                        if (checkBingo(k, l) >= 3) {
                            System.out.println(answer);
                            return;
                        }
                    }
                }
            }
        }
    }

    private static int checkBingo(int x, int y) {

        if (!rowBingo[x] && isBingo1(x)) {
            count++;
            rowBingo[x] = true;
        }

        if (!colBingo[y] && isBingo2(y)) {
            count++;
            colBingo[y] = true;
        }

        if (x == y && !diagBingo[0] && isBingo3()) {
            count++;
            diagBingo[0] = true;
        }

        if (x + y == 4 && !diagBingo[1] && isBingo4()) {
            count++;
            diagBingo[1] = true;
        }

        return count;
    }


    //가로 빙고 체크
    private static boolean isBingo1(int x) {
        for (int i = 0; i < 5; i++) {
            if (bingo[x][i] != 0) {
                return false;
            }
        }
        return true;

    }

    private static boolean isBingo2(int y) {
        for (int i = 0; i < 5; i++) {
            if (bingo[i][y] != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBingo3() {
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBingo4() {
        for (int i = 0; i < 5; i++) {
            if (bingo[i][4 - i] != 0) {
                return false;
            }
        }
        return true;
    }
}
