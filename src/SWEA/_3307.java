package SWEA;

import java.util.List;
import java.util.Scanner;

public class _3307 {
    static int[] arr;
    static int max, n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            n = sc.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int[] dp = new int[n];
            dp[0] = 1;
            max = 1;
            for (int i = 1; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j] && dp[j] >= dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
                max = Math.max(max, dp[i]);
            }
            System.out.println("#" + tc + " " + max);
        }
    }


}
