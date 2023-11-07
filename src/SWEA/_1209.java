package SWEA;

import java.util.Scanner;

public class _1209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            int test = sc.nextInt();
            int[][] map = new int[100][100];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            int row = rowSum(map);
            int column = columnSum(map);
            int diagonalSum1 = diagonalSum1(map);
            int diagonalSum2 = diagonalSum2(map);

            int max1 = Math.max(row, column);
            int max2 = Math.max(diagonalSum1, diagonalSum2);
            int answer = Math.max(max1, max2);
            System.out.println("#" + t + " " + answer);
        }

    }

    private static int rowSum(int[][] map) {
        int rowResult = 0;
        int sum = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                sum += map[i][j];
            }
            rowResult = Math.max(rowResult, sum);
            sum = 0;
        }
        return rowResult;
    }

    private static int columnSum(int[][] map) {
        int columnResult = 0;
        int sum = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                sum += map[j][i];
            }
            columnResult = Math.max(columnResult, sum);
            sum = 0;
        }
        return columnResult;
    }

    private static int diagonalSum1(int[][] map) {
        int diagonalSum1 = 0;
        for (int i = 0; i < map.length; i++) {
            diagonalSum1 += map[i][i];
        }
        return diagonalSum1;
    }

    private static int diagonalSum2(int[][] map) {
        int diagonalSum2 = 0;
        for (int i = 0; i < map.length; i++) {
            diagonalSum2 += map[i][map.length - 1 - i];
        }
        return diagonalSum2;
    }

}
