package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18111 {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }
        int answer_time = Integer.MAX_VALUE;
        int answer_high = 0;

        for (int i = min; i <= max; i++) {
            int time = 0;
            int block = b;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[j][k] < i) {
                        time += i - map[j][k];
                        block -= i - map[j][k];
                    } else if (map[j][k] > i) {
                        time += (map[j][k] - i) * 2;
                        block += map[j][k] - i;
                    }
                }
            }
            if (block < 0) {
                continue;
            }
            if (answer_time >= time) {
                answer_time = time;
                answer_high = Math.max(answer_high, i);
            }

        }
        System.out.println(answer_time + " " + answer_high);



    }
}
