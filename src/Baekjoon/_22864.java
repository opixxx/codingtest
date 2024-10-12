package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _22864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); //피로도
        int B = Integer.parseInt(st.nextToken()); //처리량
        int C = Integer.parseInt(st.nextToken()); //휴식
        int M = Integer.parseInt(st.nextToken()); //최대 피로도


        int curA = 0;
        int curB = 0;
        for (int i = 0; i < 24; i++) {
            if (curA + A <= M) {
                curA += A;
                curB += B;
            } else {
                curA -= C;
                if (curA < 0) {
                    curA = 0;
                }
            }
        }
        System.out.println(curB);
    }
}
