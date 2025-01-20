package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20922v2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] ch = new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = 0;
        int max = Integer.MIN_VALUE;
        while (rt < n) {
            if (ch[arr[rt]] < k) {
                ch[arr[rt]]++;
                rt++;
            } else if (ch[arr[rt]] == k) {
                ch[arr[lt]]--;
                lt++;

            }
            max = Math.max(max, rt - lt);
        }
        System.out.print(max);





    }
}
