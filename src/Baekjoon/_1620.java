package Baekjoon;

import java.util.HashMap;
import java.util.Scanner;

public class _1620 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "";

        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<String, Integer> map = new HashMap<>();
        String[] arr = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.next();
            map.put(arr[i], i);
        }

        for (int i = 0; i < m; i++) {
            String str = sc.next();
            if (isStringNumber(str)) {
                int index = Integer.parseInt(str);
                answer += arr[index];
            } else {
                answer += map.get(str);
            }
            answer += "\n";
        }
        System.out.println(answer);
    }

    public static boolean isStringNumber(String str) {
        try {
            int a = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
