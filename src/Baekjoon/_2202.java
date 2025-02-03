package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        double lt = 0;
        double rt = Math.min(x, y);

        while (lt + 0.001 <= rt) {
            double mid = (lt + rt) / 2;
            double h1 = Math.sqrt(Math.pow(x, 2) - Math.pow(mid, 2));
            double h2 = Math.sqrt(Math.pow(y, 2) - Math.pow(mid, 2));
            double result = (h1 * h2) / (h1 + h2);

            if (result >= c) {
                lt = mid;
            } else {
                rt = mid;
            }
        }
        System.out.printf("%.3f%n", lt);
    }
}
