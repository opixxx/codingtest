package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            List<Score> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new Score(a, b));
            }
            list.sort(Comparator.comparingInt(score -> score.a));
            int answer = 1;
            int min = list.get(0).b;

            for (int j = 1; j < n; j++) {
                if (list.get(j).b < min) {
                    min = list.get(j).b;
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);

    }

    static class Score {
        int a;
        int b;

        public Score(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
