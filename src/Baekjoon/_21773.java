package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _21773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Process> pq = new PriorityQueue<>(
                Comparator.comparingInt((Process p) -> p.c).reversed()
                        .thenComparingInt(p -> p.a)
        );

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.offer(new Process(a, b, c));
        }

        StringBuilder sb = new StringBuilder();
        int time = 1;
        while (time++ <= t) {
            if (pq.isEmpty()) {
                break;
            }
            Process process = pq.poll();
            sb.append(process.a).append("\n");
            process.b--;
            if (process.b > 0) {
                process.c--;
                pq.offer(process);
            }

        }
        System.out.println(sb);
    }

    static class Process {
        int a; //프로세스 아이디
        int b; //프로세스 실행 시간
        int c; //프로세스 우선 순위


        public Process(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
