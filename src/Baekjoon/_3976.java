package Baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class _3976 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String input = sc.next();
            if (input.length() % 2 != 0) {
                continue;
            }
            stack.push(input.charAt(0));
            for (int j = 1; j < input.length(); j++) {
                if (stack.size() > 0 && stack.peek() == input.charAt(j)) {
                    stack.pop();
                } else {
                    stack.push(input.charAt(j));
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
