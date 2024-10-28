package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1916v2 {
    static ArrayList<ArrayList<Node>> graph;
    static int n, m;
    static int[] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //도시 수
        m = Integer.parseInt(br.readLine()); //버스 수

        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }
        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.offer(new Node(start, 0));
        dis[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int city = cur.city;
            int cost = cur.cost;

            if (cost > dis[city]) continue;
            for (Node node : graph.get(city)) {
                if (dis[node.city] > cost + node.cost) {
                    dis[node.city] = cost + node.cost;
                    pq.offer(new Node(node.city, cost + node.cost));
                }
            }
        }
        return dis[end];
    }

    static class Node {
        int city;
        int cost;

        public Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }
}
