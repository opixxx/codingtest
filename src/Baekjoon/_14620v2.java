package Baekjoon;

import java.util.Scanner;

public class _14620v2 {
    static int n, answer = Integer.MAX_VALUE;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        recursive(0, 0);
        System.out.println(answer);
    }
    private static void recursive(int count, int sum) {
        if (count == 3) {
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && isRange(i, j)) {
                    visited[i][j] = true;
                    int cost = arr[i][j];
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dx[k];
                        visited[nx][ny] = true;
                        cost += arr[nx][ny];
                    }
                    recursive(count + 1, sum + cost);
                    visited[i][j] = false;
                    reset(i, j);
                }
            }
        }
    }

    private static boolean isRange(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {

                return false;
            }
        }
        return true;
    }

    private static void reset(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            visited[nx][ny] = false;
        }
    }
}
