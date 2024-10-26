package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15661 {
    static int n;
    static boolean[] ch;
    static int[][] ability;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ability = new int[n][n];
        ch = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        subset(0);
        System.out.println(answer);
    }

    private static void subset(int L) {
        if (L == n) {
            int start = 0;
            int link = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (ch[i] != ch[j]) continue; //같은 팀이 아님
                    if (ch[i]) { //true -> start 팀
                        start += ability[i][j] + ability[j][i];
                    } else { //flase -> link 팀
                        link += ability[i][j] + ability[j][i];
                    }
                }
            }

            answer = Math.min(answer, Math.abs(start - link));
            return;
        }

        ch[L] = true;
        subset(L + 1);
        ch[L] = false;
        subset(L + 1);

    }
}
