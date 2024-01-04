package Baekjoon;

import java.util.Scanner;

public class _14391 {
    static int n, m, answer = 0;

    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        DFS(0, 0);
        System.out.println(answer);

    }

    private static void DFS(int x, int y) {
        if (x == n) {
            getSum();
            return;
        }
        if (y >= m) {
            DFS(x + 1, 0);
            return;
        }

        visited[x][y] = true; // 가로 선택
        DFS(x, y + 1);

        visited[x][y] = false;
        DFS(x, y + 1);
    }

    private static void getSum() {
        int result = 0;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            temp = 0;
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    temp *= 10;
                    temp += arr[i][j];
                } else {
                    result += temp;
                    temp = 0;
                }
            }
            result += temp;
        }

        for (int i = 0; i < m; i++) {
            temp = 0;
            for (int j = 0; j < n; j++) {
                if (!visited[j][i]) {
                    temp *= 10;
                    temp += arr[j][i];
                } else {
                    result += temp;
                    temp = 0;
                }
            }
            result += temp;
        }

        answer = Math.max(result, answer);
    }
}
