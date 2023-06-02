package StackQueue;

import java.util.*;

public class _05_02 {
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == '(') stack.push(x);
            else if (x == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                if (stack.isEmpty()) {
                    answer += x;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        _05_02 T = new _05_02();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
