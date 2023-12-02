package Baekjoon;

import java.util.Scanner;

public class _10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 1;

        String str = sc.next();
        String sb = new StringBuffer(str).reverse().toString();

        if (!str.equals(sb)) {
            answer = 0;
        }

        System.out.println(answer);
    }
}
