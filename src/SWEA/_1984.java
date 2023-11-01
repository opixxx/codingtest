package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class _1984 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        for (int i = 1; i <= test; i++) {
            int[] arr = new int[10];
            for (int j = 0; j < 10; j++) {
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr);
            int sum = 0;
            for (int j = 1; j < 9; j++) {
                sum += arr[j];
            }
            int average = (int)Math.round((double)sum / 8);

            System.out.println("#" + i + " " + average);
        }
    }
}
