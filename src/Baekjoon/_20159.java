package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] a = new long[n / 2 + 1]; //정훈
        long[] b = new long[n / 2 + 1]; //상대

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n / 2; i++) {
            a[i] = a[i - 1] + Long.parseLong(st.nextToken());
            b[i] = b[i - 1] + Long.parseLong(st.nextToken());
        }

        long result = a[n / 2];
        long tmp = 0;
        for (int i = 0; i < n; i++) {
            // 정훈이 차례에서 밑장 뺴기
            if (i % 2 == 1) {
                tmp = a[i / 2] + (b[n / 2] - b[i / 2]);

            }
            // 상대 차례에서 밑장 뺴기
            else {
                tmp = a[i / 2 + 1] + (b[n / 2 - 1] - b[i / 2]);
            }
            result = Math.max(result, tmp);
        }
        System.out.println(result);


    }
}
