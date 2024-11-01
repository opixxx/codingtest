package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _18405 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static Queue<Node> q = new ArrayDeque<>();
    static boolean[][] ch;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) {
                    list.add(new Node(i, j, arr[i][j], 0));

                }
            }
        }
        list.sort(Comparator.comparingInt(a -> a.virus));
        for (Node node : list) {
            q.offer(node);
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;

        bfs(s);
        System.out.println(arr[x][y]);
    }

    private static void bfs(int s) {

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.time == s) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = cur.virus;
                        q.offer(new Node(nx, ny, cur.virus, cur.time + 1));
                    }
                }

            }
        }

    }

    static class Node {
        int x;
        int y;
        int virus;
        int time;

        public Node(int x, int y, int virus, int time) {
            this.x = x;
            this.y = y;
            this.virus = virus;
            this.time = time;
        }

    }
}
