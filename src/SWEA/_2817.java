package SWEA;

import java.util.Scanner;

public class _2817 {
    static int[] arr;
    static int n, k;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            count = 0;
            n = sc.nextInt();
            k = sc.nextInt();
            arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            DFS(0, 0);
            System.out.println("#" + tc + " " + count);

        }
    }

    public static void DFS(int idx, int total) {
        if (idx == arr.length) {
            if (total == k) {
                count++;
            }
            return;
        }
        DFS(idx + 1, total + arr[idx]);
        DFS(idx + 1, total);
    }
}

