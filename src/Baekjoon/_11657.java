package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _11657 {
    static int n, m;
    static List<List<Node>> list;
    static long[] dis;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        dis = new long[n + 1];
        Arrays.fill(dis, INF);

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, c));
        }
        StringBuilder sb = new StringBuilder();
        if (bellmanFord()) {
            sb.append("-1\n");
        } else {
            for (int i = 2; i <= n; i++) {
                if (dis[i] == INF) {
                    sb.append("-1\n");
                } else {
                    sb.append(dis[i]).append("\n");
                }
            }
        }
        System.out.println(sb);

    }

    private static boolean bellmanFord() {
        dis[1] = 0;
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            flag = false;

            for (int j = 1; j <= n; j++) {
                for (Node node : list.get(j)) {
                    if (dis[j] == INF) {
                        break;
                    }
                    if (dis[node.end] > dis[j] + node.weight) {
                        dis[node.end] = dis[j] + node.weight;
                        flag = true;
                    }
                }
            }

            if (!flag) {
                break;
            }
        }

        if (flag) {
            for (int i = 1; i <= n; i++) {
                for (Node node : list.get(i)) {
                    if (dis[i] == INF) {
                        break;
                    }
                    if (dis[node.end] > dis[i] + node.weight) {
                        return true;
                    }
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
