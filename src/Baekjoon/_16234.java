package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _16234 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int n, l, r;
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int count = 0;

        while (true) {
            boolean check = false;

            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        if (BFS(i, j)) {
                            check = true;

                        }
                    }
                }
            }
            if (!check) {
                break;
            }
            count++;

        }
        System.out.println(count);

    }

    public static boolean BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        LinkedList<Point> tmp = new LinkedList<>();
        q.add(new Point(x, y));
        tmp.add(new Point(x, y));

        int sum = arr[x][y];
        int cnt = 1;
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    int diff = Math.abs(arr[cur.x][cur.y] - arr[nx][ny]);
                    if (diff >= l && diff <= r) {
                        q.add(new Point(nx, ny));
                        tmp.add(new Point(nx, ny));
                        sum += arr[nx][ny];
                        cnt++;
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        if (cnt > 1) {
            int result = sum / cnt;
            for (Point p : tmp) {
                arr[p.x][p.y] = result;
            }
            return true;
        }
        return false;
    }
}
