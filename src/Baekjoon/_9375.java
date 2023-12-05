package Baekjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class _9375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int i = 0; i < test; i++) {
            int answer = 1;
            HashMap<String, Integer> map = new HashMap<>();
            int n = sc.nextInt();

            for (int j = 0; j < n; j++) {
                String name = sc.next();
                String category = sc.next();
                map.put(category, map.getOrDefault(category, 0) + 1);
            }

            for (int value : map.values()) {
                answer *= value + 1;
            }
            System.out.println(answer - 1);
        }
    }
}
