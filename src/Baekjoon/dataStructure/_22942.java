package Baekjoon.dataStructure;


import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

class Circle implements Comparable<Circle> {
    int index;
    int type;
    int num;

    public Circle(int index, int type, int num) {
        this.index = index;
        this.type = type;
        this.num = num;
    }
    @Override
    public int compareTo(Circle o) {
        if (this.num == o.num) {
            return this.type - o.type; // 오름차순 o.type - this.type 내림차순
        }
        return this.num - o.num; // 오름차순 정렬

    }
}
public class _22942 {
    static PriorityQueue<Circle> pq = new PriorityQueue<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int r = sc.nextInt();
            pq.add(new Circle(i, 0, x - r));
            pq.add(new Circle(i, 1, x + r));

        }

        Stack<Circle> st = new Stack<>();

        while (!pq.isEmpty()) {
            Circle tmp = pq.poll();

            if (tmp.type == 0) {
                st.push(tmp);
            } else {
                if (st.isEmpty() || st.peek().index != tmp.index) {
                    System.out.println("NO");
                    return;
                }
                st.pop();
            }
        }
        System.out.println("YES");
    }

}