package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> positive = new ArrayList<>(); // 양수
        List<Integer> negative = new ArrayList<>(); // 음수, 0

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input > 0) {
                positive.add(input);
            } else {
                negative.add(input);
            }
        }
        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative);

        int idx = 0;
        int sum = 0;
        while (idx < positive.size()) {
            if (idx + 1 < positive.size() && positive.get(idx + 1) != 1 && positive.get(idx) != 1) {
                sum += positive.get(idx) * positive.get(idx + 1);
                idx += 2;
            } else {
                sum += positive.get(idx);
                idx++;
            }
        }

        idx = 0;
        while (idx < negative.size()) {
            if (idx + 1 < negative.size()) {
                sum += negative.get(idx) * negative.get(idx + 1);
                idx += 2;
            } else {
                sum += negative.get(idx);
                idx++;
            }
        }

        System.out.println(sum);


    }
}
