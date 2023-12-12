package Baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _4659 {
    static List<Character> aeiou = Arrays.asList('a' , 'e' , 'i' , 'o' , 'u');

    public static boolean haveMo(List<Character> list) {
        return (list.contains('a') || list.contains('e') || list.contains('o') || list.contains('u') || list.contains(
                'i'));
    }
    public static boolean isHighQuality(String s) {

        char[] ch = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : ch) {
            list.add(c);
        }
        if (!haveMo(list)) {
            return false;
        }

        for (int i = 0; i < ch.length - 2; i++) {
            if (aeiou.contains(ch[i])) {
                if (aeiou.contains(ch[i + 1]) && aeiou.contains(ch[i + 2])) {
                    return false;
                }
            } else {
                if (!aeiou.contains(ch[i + 1]) && !aeiou.contains(ch[i + 2])) {
                    return false;
                }
            }
        }
        for (int i = 0; i < ch.length - 1; i++) {
            if (ch[i] == ch[i + 1]) {
                if (ch[i] != 'e' && ch[i] != 'o') {
                    return false;
                }
            }
        }
        return true;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String answer = "is acceptable.";
            String input = sc.next();
            if (input.equals("end")) {
                break;
            }

            if (isHighQuality(input)) {
                System.out.println("<" + input + "> " + answer);
            } else {
                answer = "is not acceptable.";
                System.out.println("<" + input + "> " + answer);
            }
        }
    }
}
