package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Compare implements Comparable<Compare> {

    int n; // 원본
    int m; // 절댓값

    public Compare(int n, int m) {
        this.n = n;
        this.m = m;
    }

    @Override
    public int compareTo(Compare o) {
        if (this.m == o.m) {
            return this.n - o.n;
        } else {
            return this.m - o.m;
        }
    }
}
public class _11286 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        PriorityQueue<Compare> pq = new PriorityQueue<>();

        for (int i = 0; i < t; i++) {
            int value = Integer.parseInt(br.readLine());
            int abs = Math.abs(value);
            if (value == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    int output = pq.poll().n;
                    sb.append(output).append("\n");
                }
            } else {
                pq.offer(new Compare(value, abs));
            }

        }

        System.out.println(sb);
        
    }
}
