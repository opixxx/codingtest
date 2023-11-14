package SWEA;

import java.util.Scanner;

public class _2806 {
    static int n, count;
    static int[] rows;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            n = sc.nextInt();
            rows= new int[n];
            count = 0;
            NQueen(0);
            System.out.println("#" + tc + " " + count);

        }

}
    private static void NQueen(int row) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            rows[row] = col;
            if (isPossible(row)) {
                NQueen(row + 1);

            }
        }

    }

    private static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            if (rows[row] == rows[i] || Math.abs(row - i) == Math.abs(rows[row] - rows[i])) {
                return false;
            }
        }
        return true;
    }
}

