package Baekjoon;

import java.util.Scanner;

public class _14405 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String answer = "NO";
        String input = sc.next();
        int check = 0;
        // pi, ka, chu
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'p') {
                if (i + 2 > input.length()) {
                    break;
                }
                String tmp = input.substring(i, i + 2);
                if (tmp.equals("pi")) {
                    check += 2;
                }

            }
            if (input.charAt(i) == 'c') {
                if (i + 3 > input.length()) {
                    break;
                }
                String tmp = input.substring(i, i + 3);
                if (tmp.equals("chu")) {
                    check += 3;
                }
            }
            if (input.charAt(i) == 'k') {
                if (i + 2 > input.length()) {
                    break;
                }
                String tmp = input.substring(i, i + 2);
                if (tmp.equals("ka")) {
                    check += 2;
                }
            }
            if (check == input.length()) break;
        }
        if (check == input.length()) {
            answer = "YES";
        }
        System.out.println(answer);
    }
}
//        Scanner sc = new Scanner(System.in);
//        String input = sc.next();
//
//        String regex = "pi|ka|chu";
//
//        input = input.replaceAll(regex, "");
//
//        if (input.equals("")) {
//            System.out.println("YES");
//        } else {
//            System.out.println("NO");
//        }
//
//    }
