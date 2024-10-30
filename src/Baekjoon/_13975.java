package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            long answer = 0;
            while (pq.size() > 1) {
                long first = pq.poll();
                long second = pq.poll();
                long now = first + second;
                answer += now;
                pq.offer(now);
            }

            System.out.println(answer);
        }
    }
}
