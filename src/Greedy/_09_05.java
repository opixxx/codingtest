package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    public int id, distance;
    Node(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }
    @Override
    public int compareTo(Node o) {
        return this.distance - o.distance; // 오름차순
    }
}
public class _09_05 {
    static ArrayList<ArrayList<Node>> graph;
    static int n, m;
    static int[] dis;
    public void solution(int v) {
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        dis[v] = 0;
        pQ.offer(new Node(v, 0));
        while (!pQ.isEmpty()) {
            Node tmp = pQ.poll();
            int nowId = tmp.id;
            int nowDistance = tmp.distance;
            for (Node ob : graph.get(nowId)) {
                if (dis[ob.id] > nowDistance + ob.distance ) {
                    dis[ob.id] = nowDistance + ob.distance;
                    pQ.offer(new Node(ob.id, nowDistance + ob.distance));
                }
            }
        }
    }
    public static void main(String[] args) {
        _09_05 T = new _09_05();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(); // 시작정점
            int b = sc.nextInt(); // 도착정점
            int c = sc.nextInt(); // distance
            graph.get(a).add(new Node(b,c));
        }

        T.solution(1);
        for (int i = 2; i <= n ; i++) {
            if (dis[i] == Integer.MAX_VALUE) System.out.println(i + " : Impossible");
            else System.out.println(i + " : " + dis[i]);
        }


    }
}
