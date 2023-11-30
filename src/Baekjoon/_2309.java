package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class _2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        int fake1 = 0;
        int fake2 = 0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    fake1 = i;
                    fake2 = j;
                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == fake1 || i == fake2) {
                continue;
            }
            System.out.println(arr[i]);
        }

    }
}
