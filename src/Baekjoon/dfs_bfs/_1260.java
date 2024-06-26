package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1260 {
    static int[] ch;
    static int[][] arr;
    static int node, line, root;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        root = Integer.parseInt(st.nextToken());
        ch = new int[node + 1];

        arr = new int[node + 1][node + 1];

        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }
        dfs(root);
        sb.append("\n");
        ch = new int[node + 1];

        bfs(root);
        System.out.println(sb);


    }

    private static void bfs(int root) {
        q.offer(root);
        ch[root] = 1;

        while (!q.isEmpty()) {
            root = q.poll();
            sb.append(root).append(" ");
            for (int i = 1; i <= node; i++) {
                if (arr[root][i] == 1 && ch[i] == 0) {
                    q.offer(i);
                    ch[i] = 1;
                }
            }
        }
    }

    public static void dfs(int root) {
        ch[root] = 1;
        sb.append(root).append(" ");

        for (int i = 1; i <= node; i++) {
            if (arr[root][i] == 1 && ch[i] == 0) {
                dfs(i);
            }
        }
    }
}
