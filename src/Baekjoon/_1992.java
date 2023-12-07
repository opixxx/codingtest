package Baekjoon;

import java.util.Scanner;

public class _1992 {
    static int[][] arr;
    public static StringBuilder sb = new StringBuilder();
    public static void QuadTree(int x, int y, int size) {
        if (isPossible(x, y, size)) {
            sb.append(arr[x][y]);
            return;
        }

        int newSize = size / 2;

        sb.append('(');

        QuadTree(x, y, newSize); //2사분면
        QuadTree(x, y + newSize, newSize); //1사분면
        QuadTree(x + newSize, y, newSize); //3사분면
        QuadTree(x + newSize, y + newSize, newSize); //4사분면

        sb.append(')');
    }

    private static boolean isPossible(int x, int y, int size) {
        int value = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (value != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }
        QuadTree(0, 0, N);
        System.out.println(sb);

    }
}
