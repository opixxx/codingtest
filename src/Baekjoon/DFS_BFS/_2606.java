package Baekjoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2606 {
    static int[] ch;
    static int n, m;
    static int[][] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); //컴퓨터 수
        m = Integer.parseInt(br.readLine()); //연결되어 있는 컴퓨터 쌍

        arr = new int[n + 1][n + 1];
        ch = new int[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        dfs(1);

        System.out.println(answer);

    }

    private static void dfs(int root) {
        ch[root] = 1;

        for (int i = 1; i <= n; i++) {
            if (arr[root][i] == 1 && ch[i] == 0) {
                ch[i] = 1;
                answer++;
                dfs(i);
            }
        }


    }
}
