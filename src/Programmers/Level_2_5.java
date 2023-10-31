package Programmers;

import java.util.Stack;

public class Level_2_5 {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (char x : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != x) stack.push(x);
            else stack.pop();

        }
        if (stack.isEmpty()) return 1;

        return answer;
    }

    public static void main(String[] args) {
        Level_2_5 T = new Level_2_5();
        String str = "baabaa";
        System.out.println(T.solution(str));
    }
}
