package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1504 {
    static int n, e;
    static ArrayList<ArrayList<Node>> list;
    static int[] dist;
    static boolean[] ch;
    static int INF = 200_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        dist = new int[n + 1];
        ch = new boolean[n + 1];

        Arrays.fill(dist, INF);

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, weight));
            list.get(end).add(new Node(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int answer1 = 0;
        answer1 += dijkstra(1, v1);
        answer1 += dijkstra(v1, v2);
        answer1 += dijkstra(v2, n);

        int answer2 = 0;
        answer2 += dijkstra(1, v2);
        answer2 += dijkstra(v2, v1);
        answer2 += dijkstra(v1, n);
        int answer = (answer1 >= INF && answer2 >= INF) ? -1 : Math.min(answer1, answer2);

        System.out.println(answer);
    }

    static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(ch, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] ch = new boolean[n + 1];

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (!ch[cur]) {
                ch[cur] = true;

                for (Node node : list.get(cur)) {
                    if (!ch[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;
                        pq.offer(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }

        return dist[end];
    }


    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }

    }
}
