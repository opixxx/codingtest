package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            Deque<Integer> dq = changeArr(input);
            System.out.println(solution(command, dq));

        }
    }

    private static Deque<Integer> changeArr(String input) {
        Deque<Integer> dq = new LinkedList<>();
        if (!input.equals("[]")) {
            String value = input.substring(1, input.length() - 1);

            String[] split = value.split(",");
            for (String s : split) {
                dq.add(Integer.parseInt(s.trim()));
            }

        }
        return dq;
    }

    static String solution(String command, Deque<Integer> dq) {
        boolean flag = false;
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'R') {
                flag = !flag;
            } else {
                if (!dq.isEmpty()) {
                    if (flag) {
                        dq.removeLast();
                    } else {
                        dq.removeFirst();
                    }
                } else {
                    return "error";
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!dq.isEmpty()) {
            if (flag) {
                sb.append(dq.removeLast());
            } else {
                sb.append(dq.removeFirst());
            }
            if (!dq.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
