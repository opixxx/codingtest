package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _4485 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 1;
        while (true) {

            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            int[][] arr = new int[n][n];
            int[][] map = new int[n][n];

            for (int[] row : map) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }

            ch = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem ").append(count).append(": ").append(bfs(arr, map, n)).append("\n");
            count++;

        }
        System.out.println(sb);
    }

    private static int bfs(int[][] arr, int[][] map,int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        map[0][0] = arr[0][0];
        pq.offer(new Node(0, 0, arr[0][0]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] > arr[nx][ny] + cur.cost) {
                        map[nx][ny] = arr[nx][ny] + cur.cost;
                        pq.offer(new Node(nx, ny, cur.cost + arr[nx][ny]));
                    }
                }
            }
        }
        return map[n - 1][n - 1];
    }

    static class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
