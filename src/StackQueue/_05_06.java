package StackQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _05_06 {
    public int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i); // 1,2,3,4,5,6,7 ,,, n Queue 에 넣기
        }
        while (!q.isEmpty()) {// Queue 가 비어지면 while 문 종료
            for (int i = 1; i < k; i++) {
                q.offer(q.poll()); // queue 에 맨앞에 값을 다시 queue 에 삽입
            }
            q.poll();
            if (q.size() == 1) {
                answer = q.poll();
            }
        }

        return answer;



    }
    public static void main(String[] args) {
        _05_06 T = new _05_06();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(T.solution(n, k));
    }
}
