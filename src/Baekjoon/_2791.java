package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2791 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] color = new int[m];

        for (int i = 0; i < m; i++) {
            color[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(color);

        int lt = 1;
        int rt = color[m - 1];
        int answer = 0;

        while (lt <= rt) {

            int mid = (lt + rt) / 2;

            int cnt = 0;
            for (int i = 0; i < m; i++) {
                cnt += color[i] / mid;
                if (color[i] % mid != 0) {
                    cnt++;
                }
            }

            if (cnt > n) {
                lt = mid + 1;
            } else {
                answer = mid;
                rt = mid - 1;
            }
        }
        System.out.print(answer);

    }
}
