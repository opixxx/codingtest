package Baekjoon.dataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Print {
    int index;
    int priority;

    public Print(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

}
public class _1966 {
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        for (int i = 0; i < test; i++) {
            n = sc.nextInt();
            m = sc.nextInt();
            Queue<Print> q = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                int priority = sc.nextInt();
                q.add(new Print(j, priority));
            }
            System.out.println(solution(q));
        }
    }

    private static int solution(Queue<Print> q) {
        int count = 0;
        while (!q.isEmpty()) {
            Print tmp = q.poll();

            for (Print next : q) {
                if (next.priority > tmp.priority) {
                    q.add(tmp);
                    tmp = null;
                    break;
                }
            }

            if (tmp != null) {
                count++;
                if (tmp.index == m) {
                    return count;
                }
            }
        }
        return count;
    }
}
