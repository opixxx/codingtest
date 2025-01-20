package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class _2212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        if (k >= n) {
            System.out.print(0);
        } else {
            int[] arr = IntStream.range(0, n).map(i -> sc.nextInt()).sorted().toArray();
            int[] diff = IntStream.range(0, n - 1).map(i -> arr[i + 1] - arr[i]).sorted().toArray();
            int answer = Arrays.stream(diff, 0, n - k).sum();
            System.out.print(answer);
        }

    }
}
