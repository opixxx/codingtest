package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25682 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][m + 1];

        boolean flag = false; //flag 가 false 면 검은색 true 면 흰색
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                char c = input.charAt(j - 1);
                if (!flag && c == 'W') {
                    arr[i][j] = 1;
                } else if (flag && c == 'B') {
                    arr[i][j] = 1;
                }
                flag = !flag;
            }
            if (m % 2 == 0) {
                flag = !flag;
            }
        }

        for (int i = 1; i <= n; i++) {
            int tmp = arr[i][1];
            for (int j = 2; j <= m; j++) {
                tmp += arr[i][j];
                arr[i][j] = tmp;
            }
        }

        for (int i = 1; i <= m; i++) {
            int tmp = arr[1][i];
            for (int j = 2; j <= n; j++) {
                tmp += arr[j][i];
                arr[j][i] = tmp;
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                int tmp = arr[i][j] - arr[i - k][j] - arr[i][j - k] + arr[i - k][j - k];
                min = Math.min(min, tmp);
                max = Math.max(max, tmp);
            }
        }

        System.out.println(Math.min(min, (k * k) - max));

    }
}
