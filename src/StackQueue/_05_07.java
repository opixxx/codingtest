package StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _05_07 {
    public String solution(String a, String b) {
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();
        for (char x : a.toCharArray()) q.offer(x);
        for (char x : b.toCharArray()) {
            if (q.contains(x)) {
                if (x != q.poll()) return "NO";
            }

        }if (!q.isEmpty()) return "NO";
        return answer;
    }
    public static void main(String[] args) {
        _05_07 T = new _05_07();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next(); // 수업설계 계획서
        System.out.println(T.solution(a, b));

    }
}
