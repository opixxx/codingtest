package Baekjoon.dataStructure;

import java.util.Scanner;
import java.util.Stack;

public class _9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            System.out.println(isStack(input));
        }

    }

    private static String isStack(String input) {
        Stack<Character> st = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                if (st.isEmpty() || st.peek() != '(') {
                    return "NO";
                }
                st.pop();
            }
        }
        if (st.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
