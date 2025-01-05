package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _16206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator
                .comparingInt((Integer a) -> a % 10)
                .thenComparingInt(a -> a)
        );

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input > 10) {
                pq.offer(input);
            } else if (input == 10) {
                answer++;
            }
        }

        while (m > 0 && !pq.isEmpty()) {
            int cur = pq.poll();
            int cuttingCnt = cur / 10;
            int makeCake;
            if (cur % 10 == 0) { //10의 배수
                makeCake = cuttingCnt;
                cuttingCnt -= 1;
            } else {
                makeCake = cuttingCnt;
            }

            if (cuttingCnt > m) {
                makeCake = m;
                cuttingCnt = m;
            }

            m -= cuttingCnt;
            answer += makeCake;
        }

        System.out.println(answer);


    }
}
