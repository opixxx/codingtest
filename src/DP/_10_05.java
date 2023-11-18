package DP;

import java.util.Arrays;
import java.util.Scanner;

public class _10_05 {
    static int[] coin;
    static int m, n;
    static int[] dy;
    public int solution(int[] coin) {
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j- coin[i]] + 1);
                // int tmp = dy[j - coin[i]] + 1;
                // if (tmp < dy[j]) {
                //    dy[j] = tmp;
                // }
            }
        }
        return dy[m];


    }
    public static void main(String[] args) {
        _10_05 T = new _10_05();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        m = sc.nextInt();
        dy = new int[m + 1];
        System.out.println(T.solution(coin));


    }
}
