package SWEA;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _9229 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            int result = -1;
            int n = sc.nextInt();
            int m = sc.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr, Collections.reverseOrder());

            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (m == arr[i] + arr[j]) {
                        result = m;
                    }
                    if (m > arr[i] + arr[j]) {
                        result = Math.max(result, arr[i] + arr[j]);
                    }
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }
}
