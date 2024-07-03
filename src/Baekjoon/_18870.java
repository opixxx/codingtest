package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] sort = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = sort[i] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(sort);

        Map<Integer, Integer> map = new HashMap<>();

        int rank = 0;
        for (int value : sort) {
            if (!map.containsKey(value)) {
                map.put(value, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int value : arr) {
            sb.append(map.get(value)).append(" ");
        }

        System.out.println(sb);
    }
}
