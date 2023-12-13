package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10709 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[][] map = new char[h][w];
        int[][] answer = new int[h][w];
        boolean flag;

        for (int i = 0; i < h; i++) {
            String str = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < h; i++) {
            int count = 1;
            flag = false;
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 'c') {
                    count = 1;
                    flag = true;
                    answer[i][j] = 0;
                }
                if (flag) {
                    if (map[i][j] == '.') {
                        answer[i][j] = count++;
                    }
                } else {
                    if (map[i][j] == '.') {
                        answer[i][j] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }

}
