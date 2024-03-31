package Baekjoon.dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class _18258 {
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            queueCommand(input, sb);
        }

        System.out.print(sb);
    }

    private static void queueCommand(String input, StringBuilder sb) {
        String[] command = input.split(" ");

        switch (command[0]) {
            case "push":
                dq.offerLast(Integer.parseInt(command[1]));
                break;
            case "pop":
                if (dq.isEmpty()) sb.append(-1).append('\n');
                else sb.append(dq.pollFirst()).append('\n');
                break;
            case "size":
                sb.append(dq.size()).append('\n');
                break;
            case "empty":
                sb.append(dq.isEmpty() ? 1 : 0).append('\n');
                break;
            case "front":
                if (dq.isEmpty()) sb.append(-1).append('\n');
                else sb.append(dq.peekFirst()).append('\n');
                break;
            case "back":
                if (dq.isEmpty()) sb.append(-1).append('\n');
                else sb.append(dq.peekLast()).append('\n');
                break;
        }
    }
}
