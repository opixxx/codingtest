package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _15659 {
    static int[] num;
    static int[] operation;
    static int operationCnt;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        operation = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
            operationCnt += operation[i];
        }

        char[] result = new char[operationCnt];
        dfs(0, result);

        System.out.println(max);
        System.out.println(min);

    }

    private static void dfs(int level, char[] result) {
        if (level == operationCnt) {
            calculate(result);
            return;
        }

        if (operation[0] > 0) { // +
            result[level] = '+';
            operation[0]--;
            dfs(level + 1, result);
            operation[0]++;
        }
        if (operation[1] > 0) { // -
            result[level] = '-';
            operation[1]--;
            dfs(level + 1, result);
            operation[1]++;
        }
        if (operation[2] > 0) {
            result[level] = '*';
            operation[2]--;
            dfs(level + 1, result);
            operation[2]++;
        }
        if (operation[3] > 0) {
            result[level] = '/';
            operation[3]--;
            dfs(level + 1, result);
            operation[3]++;
        }
    }

    private static void calculate(char[] result) {
        Deque<Integer> values = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();

        values.addLast(num[0]);

        for (int i = 0; i < result.length; i++) {
            char op = result[i];
            if (op == '*' || op == '/') {
                int prevValue = values.removeLast();
                int currentValue = num[i + 1];
                if (op == '*') {
                    values.addLast(prevValue * currentValue);
                } else {
                    values.addLast(prevValue / currentValue);
                }
            } else {
                values.addLast(num[i + 1]);
                operators.addLast(op);
            }
        }

        while (!operators.isEmpty()) {
            int a = values.removeFirst();
            int b = values.removeFirst();
            char op = operators.removeFirst();

            if (op == '+') {
                values.addFirst(a + b);
            } else {
                values.addFirst(a - b);
            }
        }

        int answer = values.removeFirst();

        max = Math.max(max, answer);
        min = Math.min(min, answer);
    }


}
