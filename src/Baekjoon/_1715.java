package Baekjoon;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class _1715 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        IntStream.range(0, n).forEach(i -> pq.offer(sc.nextInt()));

        int min = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            min += a + b;
            pq.offer(a + b);
        }

        System.out.print(min);

    }
}
