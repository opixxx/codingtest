package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class _2178 {
    static int n, m;
    static int[][] map,board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        map[0][0] = 0;
        board[0][0] = 1;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        while (!q.isEmpty()) {
            Point tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    q.add(new Point(nx, ny));
                    board[nx][ny] = board[tmp.x][tmp.y] + 1;
                }
            }
        }
        System.out.println(board[n - 1][m - 1]);
    }

}
