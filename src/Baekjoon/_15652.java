package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15652 {
    static int[] arr;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(1,0);

    }

    private static void dfs(int num, int level) {
        if (level == m) {
            for (int val : arr) {
                System.out.print(val + " ");

            }
            System.out.println();
            return;
        }

        for (int i = num; i <= n ; i++) {
            arr[level] = i;
            dfs(i, level + 1);
        }
    }
}
