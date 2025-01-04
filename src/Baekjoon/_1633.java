package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1633 {
    static int[] white;
    static int[] black;
    static int[][][] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {


        white = new int[1001];
        black = new int[1001];

        int index = 0;
        String s = "";
        while ((s = br.readLine()) != null && !s.isEmpty()) {
            index++;
            st = new StringTokenizer(s);
            white[index] = Integer.parseInt(st.nextToken());
            black[index] = Integer.parseInt(st.nextToken());
        }
        dp = new int[index + 1][16][16];
        solution(index, 15, 15);
        System.out.println(dp[index][15][15]);
    }

    static int solution(int idx, int whiteIdx, int blackIdx) {
        if (idx == 0) {
            return 0;
        }

        if (whiteIdx == 0 && blackIdx == 0) {
            return 0;
        }

        int answer = dp[idx][whiteIdx][blackIdx];
        if (answer != 0) {
            return answer;
        }

        answer = Math.max(answer, solution(idx - 1, whiteIdx, blackIdx));
        if (whiteIdx > 0) answer = Math.max(answer, solution(idx - 1, whiteIdx - 1, blackIdx) + white[idx]);
        if (blackIdx > 0) answer = Math.max(answer, solution(idx - 1, whiteIdx , blackIdx - 1) + black[idx]);

        dp[idx][whiteIdx][blackIdx] = answer;

        return answer;

    }
}
