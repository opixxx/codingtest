package StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class _05_04 {
    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) stack.push(x-48);
            else {
                int op1 = stack.pop();
                int op2 = stack.pop();
                if (x == '+') stack.push(op1 + op2);
                else if (x == '-') stack.push(op2 - op1);
                else if (x == '*') stack.push(op1 * op2);
                else if (x == '/') stack.push(op2 / op1);
            }

        }
        answer = stack.peek();
        return answer;

    }
    public static void main(String[] args) {
        _05_04 T = new _05_04();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));

    }
}
