package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11724 {
    static int[] ch;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ch = new int[n + 1];
        arr = new int[n + 1][n + 1];


        for (int i = 0; i < m; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (ch[i] == 0) {
                bfs(i, n);
                answer++;
            }
        }

        System.out.println(answer);

    }

    private static void bfs(int start, int n) {
        ch[start] = 1;
        for (int i = 1; i <= n; i++) {
            if (ch[i] == 0 && arr[start][i] == 1) {
                bfs(i, n);
            }
        }
    }
}
