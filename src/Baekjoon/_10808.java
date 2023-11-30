package Baekjoon;

import java.util.Scanner;

public class _10808 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int[] ch = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - 97;
            ch[c]++;
        }

        for (int a : ch) {
            System.out.print(a + " ");
        }
    }
}
