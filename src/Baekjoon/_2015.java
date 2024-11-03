package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _2015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] sumArr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        long count = 0;
        for (int i = 1; i <= n; i++) {
            count += map.getOrDefault(sumArr[i] - k, 0);
            map.put(sumArr[i], map.getOrDefault(sumArr[i], 0) + 1);
        }
        System.out.println(count);

    }
}
