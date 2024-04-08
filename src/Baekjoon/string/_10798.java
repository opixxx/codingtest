package Baekjoon.string;

import java.util.Scanner;

public class _10798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        char[][] arr = new char[5][15];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 15; j++) {
                arr[i][j] = '*';
            }
        }

        for (int i = 0; i < 5; i++) {
            String input = sc.next();
            for (int j = 0; j < input.length(); j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] != '*') {
                    sb.append(arr[j][i]);
                }
            }
        }
        System.out.println(sb);
    }
}
