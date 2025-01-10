package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        List<Pair<Integer, Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //데드라인
            int b = Integer.parseInt(st.nextToken()); //컵라면 수

            list.add(new Pair<>(a, b));
        }

        list.sort((a, b) -> b.d - a.d); // 데드라인 기준 내림차순

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.c - a.c);
//                Comparator.comparingInt((Pair<Integer, Integer> pair) -> pair.c).reversed()

        int index = 0;
        int max = 0;
        for (int i = n; i > 0; i--) {
            while (index < list.size() && list.get(index).d == i) {
                pq.offer(list.get(index));
                index++;
            }

            if (pq.isEmpty()) continue;
            int cnt = pq.poll().c;
            max += cnt;

        }
        System.out.print(max);
    }

    static class Pair<D, C> {
        D d;
        C c;

        public Pair(D d, C c) {
            this.d = d;
            this.c = c;
        }

    }
}
