package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16953 {
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        dfs(n, m, 1);
        System.out.println(answer);

    }

    private static void dfs(long n, long m, int level) {
        if (n == m) {
            answer = level;
            return;
        }
        if (n > m) {
            return;
        }
        dfs(n * 2, m, level + 1);
        String strN = String.valueOf(n);
        String nextStrN = strN + "1";
        dfs(Long.parseLong(nextStrN), m, level + 1);

    }
}
