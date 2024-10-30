package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17396 {
    static int n, m;
    static int[] ward;
    static long[] dis;
    static List<List<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ward = new int[n];
        dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ward[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, time));
            graph.get(end).add(new Node(start, time));
        }
        dijkstra(0);

        if (dis[n - 1] == Long.MAX_VALUE) {
            System.out.println(-1);

        } else {
            System.out.println(dis[n - 1]);
        }


    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.time));
        dis[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curEnd = cur.end;
            long curTime = cur.time;

            if (dis[curEnd] < curTime) continue;
            for (Node node : graph.get(curEnd)) {
                if (ward[node.end] == 1 && node.end != n - 1) continue;
                if (dis[node.end] > dis[curEnd] + node.time) {
                    dis[node.end] = dis[curEnd] + node.time;
                    pq.offer(new Node(node.end, dis[node.end]));
                }
            }
        }
    }

    static class Node {
        int end;
        long time;

        public Node(int end, long time) {
            this.end = end;
            this.time = time;
        }
    }
}
