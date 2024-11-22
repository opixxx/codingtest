package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14863 {
    static int k, n;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());

            if (i == 1) {
                dp[i][t1] = m1;
                dp[i][t2] = Math.max(dp[i][t2], m2);
            } else {
                for (int j = 0; j <= k; j++) {
                    if (dp[i - 1][j] == 0) continue;
                    if (j + t1 <= k) {
                        dp[i][j + t1] = Math.max(dp[i][j + t1], dp[i - 1][j] + m1);
                    }
                    if (j + t2 <= k) {
                        dp[i][j + t2] = Math.max(dp[i][j + t2], dp[i - 1][j] + m2);
                    }
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= k; i++) {
            answer = Math.max(answer, dp[n][i]);
        }
        System.out.println(answer);

    }


}
