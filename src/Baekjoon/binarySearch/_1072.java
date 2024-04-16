package Baekjoon.binarySearch;

import java.util.Scanner;

public class _1072 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long x = sc.nextLong();
        long y = sc.nextLong();
        long z = (y * 100) / x;

        int answer = -1;

        if (z < 99) {
            answer = (int) Math.ceil((100 * y - x * (z + 1)) / (double) (z - 99));
        }
        System.out.println(answer);
    }
}
