package Baekjoon.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _9046 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            String input = sc.nextLine();

            System.out.println(solution(input));
        }
    }

    private static char solution(String input) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : input.toCharArray()) {
            if (c != ' ') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        int maxCount = Integer.MIN_VALUE;
        char answerChar = '?';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                answerChar = entry.getKey();
            } else if (entry.getValue() == maxCount) {
                answerChar = '?';
            }
        }
        return answerChar;
    }
}
