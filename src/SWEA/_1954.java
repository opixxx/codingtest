package SWEA;

import java.util.Scanner;

public class _1954 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 1; i <= test; i++) {
            int n = sc.nextInt();
            int[][] map = new int[n][n];

            int dir = 0;
            int x = 0, y = 0;
            for (int j = 1; j <= n * n; j++) {
                map[x][y] = j;
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                } else {
                    dir = (dir + 1) % 4;
                    x += dx[dir];
                    y += dy[dir];
                }
            }
            System.out.println("#" + i);

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.print(map[j][k] + " ");
                }
                System.out.println();
            }
        }

        
    }
}
