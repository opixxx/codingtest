package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _13302 {
    static int n;
    static final int MAX = 987654321;
    static int result = MAX;
    static int[][] dp;
    static boolean[] holiday;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        holiday = new boolean[n + 1];

        if (m > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                holiday[Integer.parseInt(st.nextToken())] = true;
            }
        }

        dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, MAX);
        }

        solution(1, 0, 0);
        System.out.println(result);
    }

    private static void solution(int day, int coupon, int sum) {
        if (day > n) {
            result = Math.min(result, sum);
            return;
        }

        if (dp[day][coupon] > sum) {
            dp[day][coupon] = sum;
        } else {
            return;
        }

        if (holiday[day]) {
            solution(day + 1, coupon, sum);
        }
        if (coupon >= 3) {
            solution(day + 1, coupon - 3, sum);
        }

        solution(day + 1, coupon, sum + 10000);
        solution(day + 3, coupon + 1, sum + 25000);
        solution(day + 5, coupon + 2, sum + 37000);
    }
}
