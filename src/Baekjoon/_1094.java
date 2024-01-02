package Baekjoon;

import java.util.Scanner;

public class _1094 {
    static int[] arr = {64, 32, 16, 8, 4, 2, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int x = sc.nextInt();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= x) {
                x = x - arr[i];
                count++;
            }
        }
        System.out.println(count);
    }
}
