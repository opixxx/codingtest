package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _24023 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int curOr = 0;
        int start = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {

            int num = Integer.parseInt(st.nextToken());

            if ((num | k) != k) {
                curOr = 0;
                start = i + 1;
            } else {
                curOr |= num;

                if (curOr == k) {
                    System.out.println(start + " " +i);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
