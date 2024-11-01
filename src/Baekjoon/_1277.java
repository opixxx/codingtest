package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1277 {
    static int n, w;
    static double m;
    static final double INF = 200000;
    static double[] dis;
    static Node[] node;
    static double[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        m = Double.parseDouble(br.readLine());
        dis = new double[n + 1];
        Arrays.fill(dis, INF);

        node = new Node[n + 1];
        graph = new double[n + 1][n + 1];

        for (double[] row : graph) {
            Arrays.fill(row, INF);
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            node[i] = new Node(x, y);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    Node node1 = node[i];
                    Node node2 = node[j];
                    double distance = getDistance(node1, node2);
                    if (distance <= m) {
                        graph[i][j] = graph[j][i] = distance;
                    }
                }
            }
        }

        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = 0;
        }


        dijkstra();
        System.out.println((int) (dis[n] * 1000));
    }

    private static void dijkstra() {
        PriorityQueue<NodeDis> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a.weight));
        dis[1] = 0;
        pq.offer(new NodeDis(1, 0));

        while (!pq.isEmpty()) {
            NodeDis cur = pq.poll();
            int curEnd = cur.end;
            double curWeight = cur.weight;

            if (dis[curEnd] < curWeight) continue;
            for (int nextNode = 1; nextNode <= n; nextNode++) {
                if (graph[curEnd][nextNode] != INF) {
                    double newWeight = curWeight + graph[curEnd][nextNode];
                    if (dis[nextNode] > newWeight) {
                        dis[nextNode] = newWeight;
                        pq.offer(new NodeDis(nextNode, newWeight));
                    }
                }
            }
        }
    }

    private static double getDistance(Node node1, Node node2) {
        long dx = (long) Math.pow(node1.x - node2.x, 2);
        long dy = (long) Math.pow(node1.y - node2.y, 2);
        return Math.sqrt(dx + dy);
    }

    static class NodeDis {
        int end;
        double weight;

        public NodeDis(int end, double weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
