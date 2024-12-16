package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2470 {
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());


        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int lt = 0;
        int rt = n - 1;
        int result1 = 0;
        int result2 = 0;

        int tmp = Integer.MAX_VALUE;

        while (lt < rt) {
            int a = arr[lt] + arr[rt];
            if (tmp > Math.abs(a)) {
                tmp = Math.abs(a);
                result1 = arr[lt];
                result2 = arr[rt];
            }
            if (a < 0) {
                lt++;
            } else if (a > 0) {
                rt--;
            } else {
                result1 = arr[lt];
                result2 = arr[rt];
                break;
            }

        }

        System.out.println(result1 + " " + result2);
    }
}