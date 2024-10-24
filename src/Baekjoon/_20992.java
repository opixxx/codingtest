package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] cnt = new int[100001];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = Integer.MIN_VALUE;

        int lt = 0;
        int rt = 0;
        while (rt < n) {
            if (cnt[arr[rt]] < k) {
                cnt[arr[rt]]++;
                rt++;
            } else if (cnt[arr[rt]] == k) {
                cnt[arr[lt]]--;
                lt++;
            }

            answer = Math.max(answer, rt - lt);
        }

        System.out.println(answer);
    }
}
