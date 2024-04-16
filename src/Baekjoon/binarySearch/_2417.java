package Baekjoon.binarySearch;

import java.util.Scanner;

public class _2417 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        long start = 0;
        long end = n;
        long answer = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            double pow = Math.pow(mid, 2);
            if (n <= pow) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
