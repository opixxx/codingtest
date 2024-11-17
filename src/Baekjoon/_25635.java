package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _25635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        boolean[] ch = new boolean[n];

        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            sum += arr[i];
        }

        if (sum > arr[n - 1]) {
            System.out.println(sum + arr[n - 1]);
        } else if (sum < arr[n - 1]) {
            System.out.println(sum * 2 + 1);
        } else {
            System.out.println(sum * 2);
        }



    }
}
