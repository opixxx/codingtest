package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _10282 {
    static List<List<Node>> list;
    static long[] dis;
    static final long INF = 987654321L;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++) {
            list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int c = Integer.parseInt(st.nextToken()); // 해킹된 컴퓨터 번호

            dis = new long[n + 1];
            Arrays.fill(dis, INF);

            for (int j = 0; j <= n; j++) {
                list.add(new ArrayList<>());
            }

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); //end
                int b = Integer.parseInt(st.nextToken()); //start
                int s = Integer.parseInt(st.nextToken()); //cost

                list.get(b).add(new Node(a, s));
            }
            dijkstra(c);
            int count = 0;
            long time = 0;
            for (int j = 1; j <= n; j++) {
                if (dis[j] != INF) {
                    count++;
                    time = Math.max(time, dis[j]);
                }
            }
            sb.append(count).append(" ").append(time).append("\n");
        }
        System.out.println(sb);

    }

    private static void dijkstra(int start) {
        dis[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curEnd = cur.end;
            long curCost = cur.cost;

            if (dis[curEnd] < curCost) continue;
            for (Node node : list.get(curEnd)) {
                if (dis[node.end] > dis[curEnd] + node.cost) {
                    dis[node.end] = dis[curEnd] + node.cost;
                    pq.offer(new Node(node.end, dis[node.end]));
                }
            }
        }
    }

    static class Node {
        int end;
        long cost;

        public Node(int end, long cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
