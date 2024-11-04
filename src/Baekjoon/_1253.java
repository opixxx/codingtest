package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        int count = 0;
        for (int i = 0; i < n; i++) {
            int lt = 0;
            int rt = n - 1;
            while (true) {
                if (lt == i) {
                    lt++;
                    continue;
                } else if (rt == i) {
                    rt--;
                    continue;
                }
                if (lt >= rt) {
                    break;
                }
                if (arr[lt] + arr[rt] > arr[i]) {
                    rt--;
                } else if (arr[lt] + arr[rt] < arr[i]) {
                    lt++;
                } else {
                    count++;
                    break;
                }

            }
        }
        System.out.println(count);

    }
}
