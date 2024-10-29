package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _5972 {
    static List<List<Node>> graph;
    static int[] cow;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        cow = new int[n + 1];
        Arrays.fill(cow, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
            graph.get(end).add(new Node(start, weight));
        }

        System.out.println(dijkstra(1));
    }

    private static int dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        cow[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curEnd = cur.end;
            int curWeight = cur.weight;

            if (cow[curEnd] < curWeight) continue;
            for (Node node : graph.get(curEnd)) {
                int nodeEnd = node.end;
                int nodeWeight = node.weight;

                if (cow[nodeEnd] > nodeWeight + curWeight) {
                    cow[nodeEnd] = nodeWeight + curWeight;
                    pq.offer(new Node(nodeEnd, nodeWeight + curWeight));
                }
            }
        }
        return cow[n];
    }

    static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
