package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> minus = new PriorityQueue<>();
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input > 0) {
                plus.offer(input);
            } else if (input < 0) {
                minus.offer(input);
            }
        }


        List<Integer> result = new ArrayList<>();
        while (!plus.isEmpty()) {
            int cur = plus.poll();
            int index = m - 1;
            result.add(cur);

            while (index-- > 0) {
                if (!plus.isEmpty()) {
                    plus.poll();
                }
            }
        }

        while (!minus.isEmpty()) {
            int cur = minus.poll();
            int index = m - 1;
            result.add(Math.abs(cur));

            while (index-- > 0) {
                if (!minus.isEmpty()) {
                    minus.poll();
                }
            }
        }
        Collections.sort(result);

        int answer = 0;
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) {
                answer = answer + result.get(i);
            } else {
                answer = answer + (result.get(i) * 2);
            }
        }

        System.out.print(answer);
    }
}
