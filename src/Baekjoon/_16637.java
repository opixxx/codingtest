package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class _16637 {
    static int n, answer = Integer.MIN_VALUE;

    static ArrayList<Character> op = new ArrayList<>();
    static ArrayList<Integer> num = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        String input = sc.next();
        for (int i = 0; i < n; i++) {
            char c = input.charAt(i);
            if (i % 2 != 0) {
                op.add(c);
            } else {
                num.add(c - '0');
            }
        }
        DFS(0, num.get(0));
        System.out.println(answer);

    }

    public static void DFS(int idx, int sum) {
        if (idx == num.size() - 1) {
            answer = Math.max(sum, answer);
            return;
        }
        DFS(idx + 1, cal(op.get(idx), sum, num.get(idx + 1)));
        if (idx < num.size() - 2) {
            DFS(idx + 2, cal(op.get(idx), sum, cal(op.get(idx + 1), num.get(idx + 1), num.get(idx + 2))));
        }
    }

    private static int cal(char op, int num1, int num2) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return -1;
    }
}
