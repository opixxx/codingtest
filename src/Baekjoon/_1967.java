package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1967 {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] ch;
    static int n;
    static int max = Integer.MIN_VALUE;
    static int maxIndex = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(parent).add(new Node(child, weight));
            graph.get(child).add(new Node(parent, weight));
        }

        ch = new boolean[n + 1];
        ch[1] = true;

        dfs(1, 0);

        ch = new boolean[n + 1];
        ch[maxIndex] = true;
        dfs(maxIndex, 0);

        System.out.println(max);

    }

    private static void dfs(int index, int sum) {
        if (max < sum) {
            max = sum;
            maxIndex = index;
        }

        for (Node node : graph.get(index)) {
            if (!ch[node.id]) {
                ch[node.id] = true;
                dfs(node.id, sum + node.weight);
            }
        }
    }

    static class Node {
        int id;
        int weight;

        public Node(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }
    }
}
