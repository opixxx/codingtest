package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _18119 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int answer = n;
        int[] forgetCnt = new int[n];
        boolean[][] ch = new boolean[n][26];
        boolean[] ch1 = new boolean[n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                ch[i][c - 'a'] = true;
            }
        }

        Arrays.fill(ch1, true);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);

            if (command == '1') {
                for (int j = 0; j < n; j++) {
                    if (ch[j][c - 'a']) {
                        forgetCnt[j]++;
                        if (ch1[j]) {
                            answer--;
                            ch1[j] = false;
                        }
                    }
                }
            } else {
                for (int j = 0; j < n; j++) {
                    if (!ch1[j] && ch[j][c - 'a']) {
                        forgetCnt[j]--;
                        if (forgetCnt[j] == 0) {
                            ch1[j] = true;
                            answer++;
                        }
                    }
                }

            }
            sb.append(answer).append("\n");

        }
        System.out.println(sb);

    }
}
