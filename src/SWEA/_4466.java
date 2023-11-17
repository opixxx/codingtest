package SWEA;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _4466 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            Integer[] arr = new Integer[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr, Collections.reverseOrder());
            int answer = 0;
            for (int j = 0; j < k; j++) {
                answer += arr[j];
            }
            System.out.println("#" + (i + 1) + " " + answer);
        }
    }
}
