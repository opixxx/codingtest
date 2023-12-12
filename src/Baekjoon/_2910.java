package Baekjoon;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class _2910 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        HashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> arr = new ArrayList<>(map.keySet());

        arr.sort((a, b) -> map.get(b) - map.get(a));

        for (Integer element : arr) {
            for (int i = 0; i < map.get(element); i++) {
                System.out.print(element + " ");
            }
        }

    }
}
