package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _11067 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            List<Cafe> cafe = new ArrayList<>();
            cafe.add(new Cafe(-1, 0));
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cafe.add(new Cafe(x, y));
            }
            cafe.sort(Comparator.comparingInt((Cafe p) -> p.x).thenComparingInt(p -> p.y));

            int idx = 1;
            while (idx <= n) {
                if (cafe.get(idx).x == cafe.get(idx - 1).x) {
                    idx++;
                } else if (cafe.get(idx).y == cafe.get(idx - 1).y) {
                    idx++;
                } else {
                    int start = idx;
                    int curX = cafe.get(idx).x;

                    while (idx <= n && cafe.get(idx).x == curX) {
                        idx++;
                    }
                    List<Cafe> subList = cafe.subList(start, idx);
                    Collections.reverse(subList);
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());


            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                sb.append(cafe.get(input).x).append(" ").append(cafe.get(input).y).append("\n");
            }
        }
        System.out.println(sb);
    }

    static class Cafe {
        int x;
        int y;

        public Cafe(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
