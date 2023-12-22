package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2636 {
    static int n, m, cheese;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visitesd;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    cheese++;
                }
            }
        }
        int cheeseCount = 0;
        int time = 0;

        while (cheese != 0) {
            cheeseCount = cheese;
            time++;
            visitesd = new boolean[n][m];
            BFS();
        }
        System.out.println(time);
        System.out.println(cheeseCount);
    }
    private static void BFS() {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        visitesd[0][0] = true;

        while (!q.isEmpty()) {

            int[] current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visitesd[nx][ny]) {
                    visitesd[nx][ny] = true;
                    if (map[nx][ny] == 0) {
                        q.offer(new int[]{nx, ny});
                    } else {
                        cheese--;
                        map[nx][ny] = 0;
                    }
                }
            }
        }
    }
}
