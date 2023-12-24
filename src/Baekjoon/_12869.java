package Baekjoon;

import java.util.Scanner;

public class _12869 {
    static int[][][] dp;
    static int min;
    static int[][] attack = {{9, 3, 1}, {9, 1, 3}, {3, 1, 9}, {3, 9, 1}, {1, 9, 3}, {1, 3, 9}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scv = new int[3];

        for (int i = 0; i < n; i++) {
            scv[i] = sc.nextInt();
        }

        dp = new int[61][61][61];
        min = Integer.MAX_VALUE;
        DFS(scv, 0);

        System.out.println(min);
    }

    public static void DFS(int[] scv, int cnt) {
        int s1 = scv[0];
        int s2 = scv[1];
        int s3 = scv[2];

        if (min <= cnt) {
            return;
        }
        if (dp[s1][s2][s3] != 0 && dp[s1][s2][s3] <= cnt) {
            return;
        }
        dp[s1][s2][s3] = cnt;

        if (s1 == 0 && s2 == 0 && s3 == 0) {
            min = Math.min(min, cnt);
            return;
        }

        for (int i = 0; i < 6; i++) {
            DFS(new int[]{Math.max(s1 - attack[i][0], 0), Math.max(s2 - attack[i][1], 0),
                    Math.max(s3 - attack[i][2], 0)}, cnt + 1);

        }
    }
}
