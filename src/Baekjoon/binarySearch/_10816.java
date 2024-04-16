package Baekjoon.binarySearch;

import java.util.HashMap;
import java.util.Scanner;

public class _10816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int card = sc.nextInt();
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int find = sc.nextInt();
            if (map.containsKey(find)) {
                sb.append(map.get(find)).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}
