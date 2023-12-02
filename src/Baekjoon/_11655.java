package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

// A~Z 65~90 a~z 97~122
public class _11655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "";
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isLetter(c)) {
                answer += c;
                continue;
            }
            int n = c + 13;
            if (Character.isUpperCase(c) && n > 90) {
                n -= 26;
            }
            if (Character.isLowerCase(c) && n > 122) {
                n -= 26;
            }
            answer += (char) n;
        }
        System.out.println(answer);
    }
}

