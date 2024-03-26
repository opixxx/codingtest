package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class _20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String[] arr = input.split("\\.");

            map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
        }

        for (String str : map.keySet()) {
            System.out.println(str + " " + map.get(str));
        }
    }
}
