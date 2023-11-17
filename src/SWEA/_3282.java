package SWEA;
import java.util.Scanner;

public class _3282 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int tc = 1; tc <= test; tc++) {
            int N = sc.nextInt();
            int W = sc.nextInt();
            int[] dp = new int[W + 1];

            for (int i = 1; i <= N; i++) {
                int weight = sc.nextInt();
                int value = sc.nextInt();

                for (int j = W; j >= weight; j--) {
                    dp[j] = Math.max(dp[j], dp[j - weight] + value);
                }
            }
            System.out.println("#" + tc + " " + dp[W]);
        }
    }
}
