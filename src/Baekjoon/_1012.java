package Baekjoon;

import java.util.Scanner;

public class _1012 {
    static int[][] arr;
    static int count = 0;
    static int n, m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void DFS(int x, int y) {
        arr[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 1) {
                DFS(nx, ny);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int tc = 0; tc < test; tc++) {
            count = 0;
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();
            arr = new int[n][m];

            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                arr[y][x] = 1;

            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1) {
                        count++;
                        DFS(i, j);
                    }
                }
            }

            System.out.println(count);

        }
    }
}
