package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int h = 0; h <= n; h++) {
            for (int m = 0; m <= 59; m++) {
                for (int s = 0; s <= 59; s++) {
                    if (check(h, k, m, s)) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    static boolean check(int h, int k, int m, int s) {
        return h / 10 == k || h % 10 == k || m / 10 == k || m % 10 == k || s / 10 == k || s % 10 == k;
    }


}
