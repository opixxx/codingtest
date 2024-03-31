package Baekjoon.dataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> answer = new LinkedList<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        int index = 0;
        while (answer.size() < n) {
            index++;
            if (index % k == 0) {
                answer.add(q.poll());
            } else {
                q.add(q.poll());
            }
        }
        sb.append("<");
        int len = answer.size();
        for (int i = 0; i < len; i++) {
            if (i != len - 1) {
                sb.append(answer.poll()).append(", ");
            } else {
                sb.append(answer.poll());
            }
        }
        sb.append(">");

        System.out.println(sb);



//        String result = answer.toString();
//        String replace = result.replace('[', '<');
//        String replace1 = replace.replace(']', '>');
//        System.out.println(replace1);
    }
}