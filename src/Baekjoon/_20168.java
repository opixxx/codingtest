package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _20168 {
    static int n, m, a, b, c;
    static boolean[] ch;
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

        ch = new boolean[n + 1];
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

        dfs(a, c, -1);
        if (max == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(max);

        }

    }

    private static void dfs(int start, int cost, int maxCost) {
        if (start == b) {
            max = Math.min(max, maxCost);
        }

        for (Node node : graph.get(start)) {
            int nextNode = node.end;
            int nextCost = node.cost;

            if (ch[nextNode] || cost < nextCost) continue;
            ch[nextNode] = true;

            dfs(nextNode, cost -nextCost, Math.max(nextCost, maxCost));
            ch[nextNode] = false;

        }
    }

    static class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
