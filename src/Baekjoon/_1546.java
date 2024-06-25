package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }

        Arrays.sort(arr);
        double max = arr[arr.length - 1];
        double sum = 0;

        for (int i = 0; i < n; i++) {
            double score = arr[i];
            score = score / max * 100;
            arr[i] = score;
        }

        for (double v : arr) {
            sum += v;
        }

        System.out.println(sum / n);
    }
}
