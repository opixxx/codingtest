package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class _1916 {
    static ArrayList<ArrayList<Node>> graph;
    static int n, m;
    static int[] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine()); //도시 개수
        m = Integer.parseInt(br.readLine()); //버스 수
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //버스 시작
            int b = Integer.parseInt(st.nextToken()); //버스 도착
            int c = Integer.parseInt(st.nextToken()); //비용
            graph.get(a).add(new Node(b, c));

        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int answer = dijkstra(start, end);
        System.out.println(answer);

    }

    private static int dijkstra(int startPos, int endPos) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startPos, 0));
        dis[startPos] = 0;

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            int now = tmp.end;
            int nowDis = tmp.distance;
            if (nowDis > dis[now]) continue;
            for (Node node : graph.get(now)) {
                if (dis[node.end] > nowDis + node.distance) {
                    dis[node.end] = nowDis + node.distance;
                    pq.offer(new Node(node.end, nowDis + node.distance));
                }
            }

        }
        return dis[endPos];
    }

    static class Node implements Comparable<Node> {
        int end;
        int distance;

        public Node(int id, int distance) {
            this.end = id;
            this.distance = distance;
        }


        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance; //거리 기준 오름차순
        }
    }
}
