package Greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
class Edge_1 implements Comparable<Edge_1> {
    public int v1, cost;
    Edge_1(int v1, int cost) {
        this.v1 = v1;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge_1 o) {
        return this.cost - o.cost;
    }
}
public class _09_07v2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Edge_1>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge_1(b, c));
            graph.get(b).add(new Edge_1(a, c)); // 무방향 인접리스트
        }
        PriorityQueue<Edge_1> pQ = new PriorityQueue<>();
        pQ.offer(new Edge_1(1,0));
        int answer = 0;
        while (!pQ.isEmpty()) {
            Edge_1 tmp = pQ.poll();
            int ev = tmp.v1;
            if (ch[ev] == 0) {
                ch[ev] = 1;
                answer += tmp.cost;
                for (Edge_1 ob : graph.get(ev)) {
                    if (ch[ob.v1] == 0) pQ.offer(ob);
                }
            }
        }
        System.out.println(answer);
    }
}
