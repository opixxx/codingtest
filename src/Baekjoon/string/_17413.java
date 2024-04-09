package Baekjoon.string;

import java.util.Scanner;
import java.util.Stack;

public class _17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String input = sc.nextLine();
        Stack<Character> st = new Stack<>();
        boolean flag = true;

        for (char c : input.toCharArray()) {
            if (c == '<') {
                flag = false;
                while (!st.isEmpty()) {
                    sb.append(st.pop());
                }
                sb.append(c);
            }
            else if (c == '>') {
                flag = true;
                sb.append(c);
            }
            else if (!flag) {
                sb.append(c);
            }
            else if (flag) {
                if (c == ' ') {
                    while (!st.isEmpty()) {
                        sb.append(st.pop());
                    }
                    sb.append(c);
                }
                else {
                    st.push(c);
                }
            }
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        System.out.println(sb);
    }
}
