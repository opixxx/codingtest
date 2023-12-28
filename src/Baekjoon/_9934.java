package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _9934 {
    static int k;
    static int[] arr;
    static List<ArrayList<Integer>> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        int len = (int) Math.pow(2, k) - 1;
        arr = new int[len];

        list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        recursive(0, arr.length - 1, 0);

        for (int i = 0; i < k; i++) {
            for (int a : list.get(i)) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    public static void recursive(int start, int end, int level) {

        if (level == k) {
            return;
        }

        int root = (start + end) / 2;

        list.get(level).add(arr[root]);

        recursive(start, root - 1, level + 1);
        recursive(root + 1, end, level + 1);
    }
}
