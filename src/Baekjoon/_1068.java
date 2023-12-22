package Baekjoon;

import java.util.Scanner;

public class _1068 {
    static int[] arr;
    static boolean[] visited;
    static int root, n, count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] == -1) {
                root = i;
            }
        }
        int delete = sc.nextInt();
        deleteNode(delete);

        count = 0;
        visited = new boolean[n];
        countLeafNode(root);

        System.out.println(count);

    }

    private static void countLeafNode(int root) {
        boolean isLeaf = true;
        visited[root] = true;
        if (arr[root] != -2) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == root && !visited[i]) {
                    countLeafNode(i);
                    isLeaf = false;
                }
            }
            if (isLeaf) {
                count++;
            }
        }
    }

    public static void deleteNode(int delete) {
        arr[delete] = -2;
        for (int i = 0; i < n; i++) {
            if (arr[i] == delete) {
                deleteNode(i);
            }
        }
    }
}
