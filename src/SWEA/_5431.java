package SWEA;

import java.util.Scanner;

public class _5431 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int tc = 1; tc <= test; tc++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n + 1];
            for (int i = 0; i < k; i++) {
                int person = sc.nextInt();
                arr[person] = 1; //과제 한사람
            }

            System.out.print("#" + tc + " ");
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == 0) {
                    System.out.print(i+ " ");
                }
            }
            System.out.println();
        }
    }
}
