package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());
        char[][] map = new char[m + 1][n];
        int[][] jungle = new int[m + 1][n + 1];
        int[][] ocean = new int[m + 1][n + 1];
        int[][] ice = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 1; j <= n; j++) {
                jungle[i][j] = jungle[i - 1][j] + jungle[i][j - 1] - jungle[i - 1][j - 1];
                ocean[i][j] = ocean[i - 1][j] + ocean[i][j - 1] - ocean[i - 1][j - 1];
                ice[i][j] = ice[i - 1][j] + ice[i][j - 1] - ice[i - 1][j - 1];

                if (map[i][j - 1] == 'J') {
                    jungle[i][j]++;
                } else if (map[i][j - 1] == 'O') {
                    ocean[i][j]++;
                } else {
                    ice[i][j]++;
                }
            }
        }
        // (N1, M1) (N2, M2)
        // sums[N2][M2] - sums[N2][M1-1] - sum[N1-1][M2] + sum[N1-1][M1-1]
        StringBuilder sb = new StringBuilder();
        int jResult, oResult, iResult;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            jResult = jungle[c][d] - jungle[c][b - 1] - jungle[a - 1][d] + jungle[a - 1][b - 1];
            oResult = ocean[c][d] - ocean[c][b - 1] - ocean[a - 1][d] + ocean[a - 1][b - 1];
            iResult = ice[c][d] - ice[c][b - 1] - ice[a - 1][d] + ice[a - 1][b - 1];

            sb.append(jResult + " " + oResult + " " + iResult).append("\n");
        }
        System.out.println(sb);
    }

}
