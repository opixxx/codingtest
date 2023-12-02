package Baekjoon;

import java.util.Scanner;

public class _1159 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "";
        int n = sc.nextInt();
        int[] arr = new int[26];


        for (int i = 0; i < n; i++) {
            String str = sc.next();
            int first = str.charAt(0) - 97;
            arr[first]++;
        }
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            char tmp;
            if (arr[i] >= 5) {
                flag = true;
                tmp = (char) (i + 97);
                answer += tmp;
            }
        }
        if (!flag) {
            answer = "PREDAJA";
        }

        System.out.println(answer);
    }
}
