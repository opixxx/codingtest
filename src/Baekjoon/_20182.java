package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _20182 {
    static int n, m, a, b, c;
    static int[] dis;
    static ArrayList<ArrayList<Node>> graph;
    static int max = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 교차로 개수
        m = Integer.parseInt(st.nextToken()); // 골목 개수
        a = Integer.parseInt(st.nextToken()); // 시작 교차로 번호
        b = Integer.parseInt(st.nextToken()); // 도착 교차로 번호
        c = Integer.parseInt(st.nextToken()); // 가진 돈

        dis = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }

        System.out.println(binarySearch(a, b, c));


    }

    static int binarySearch(int start, int end, int c) {
        int lt = 1;
        int rt = 21;
        int mid;
        int answer = -1;

        while (lt <= rt) {
            mid = (lt + rt) / 2;

            if (dijkstra(start, end, c, mid)) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }

    static boolean dijkstra(int start, int end, int c, int x) {
        Arrays.fill(dis, max);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        dis[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curEnd = cur.end;
            int curWeight = cur.weight;

            if (curEnd == end) {
                return dis[curEnd] <= c;
            }

            if (dis[curEnd] < curWeight) continue;
            for (Node node : graph.get(curEnd)) {
                if (node.weight > x) continue;
                if (dis[node.end] > dis[curEnd] + node.weight) {
                    dis[node.end] = dis[curEnd] + node.weight;
                    pq.offer(new Node(node.end, dis[node.end]));
                }
            }
        }
        return false;
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
