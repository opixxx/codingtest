package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class _05_01 {
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            }
            else if (x == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return "NO";
                stack.pop();
            }
        }
        if (stack.isEmpty()) answer = "YES";
        else answer = "NO";
        return answer;


    }
    public static void main(String[] args) {
        _05_01 T = new _05_01();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
