package Baekjoon.binarySearch;

import java.io.IOException;
import java.util.Scanner;

public class _1789 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();

        long count = 1;
        long sum = 0;

        while (s >= sum) {
            sum += count;
            count++;
        }
        System.out.println(count - 2);
    }
}
