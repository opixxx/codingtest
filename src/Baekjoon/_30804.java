package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _30804 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int lt = 0;
        int maxLen = 0;

        for (int rt = 0; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);

            while (map.size() > 2) {
                map.put(arr[lt], map.get(arr[lt]) - 1);
                if (map.get(arr[lt]) == 0) {
                    map.remove(arr[lt]);
                }
                lt++;
            }

            maxLen = Math.max(maxLen, rt - lt + 1);
        }

        System.out.println(maxLen);
    }
}