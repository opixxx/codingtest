package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _23254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()) * 24;
        int m = Integer.parseInt(st.nextToken());

        int[] score = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> b.number - a.number);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            pq.add(new Point(i, Integer.parseInt(st.nextToken())));
        }


        while (n > 0 && !pq.isEmpty()) {
            var cur = pq.poll();
            int time = (100 - score[cur.id]) / cur.number;
            int realTime = Math.min(time, n);
            n -= realTime;

            score[cur.id] += cur.number * realTime;


            if (score[cur.id] != 100) {
                pq.offer(new Point(cur.id, 100 - score[cur.id]));
            }

        }

        int result = 0;
        for (int a : score) {
            result += a;
        }
        System.out.println(result);



    }

    static class Point {
        int id;
        int number;

        public Point(int id, int number) {
            this.id = id;
            this.number = number;
        }
    }
}
