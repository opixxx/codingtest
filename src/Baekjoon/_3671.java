package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _3671 {
    static int[] arr;
    static boolean[] ch;
    static HashSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            String input = br.readLine();
            arr = new int[input.length()];
            set = new HashSet<>();
            ch = new boolean[input.length()];


            for (int i = 0; i < arr.length; i++) {
                arr[i] = input.charAt(i) - '0';
            }
            for (int i = 0; i < arr.length; i++) {
                dfs("", 0);
            }

            sb.append(set.size()).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
             if (num % i == 0) return false;
        }
        return true;
    }

    private static void dfs(String cur, int level) {
        if (!cur.isEmpty()) {
            int num = Integer.parseInt(cur);
            if (isPrime(num)) {
                set.add(num);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (!ch[i]) {
                ch[i] = true;
                dfs(cur + arr[i], level + 1);
                ch[i] = false;
            }
        }
    }
}
