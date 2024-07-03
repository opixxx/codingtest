package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class _10026 {
    static Queue<Point> q = new LinkedList<>();

    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        char[][] arr1 = new char[n][n];
        char[][] arr2 = new char[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            arr1[i] = input.toCharArray();
            for (int j = 0; j < n; j++) {
                char value = input.charAt(j);
                if (value == 'G') {
                    value = 'R';
                }
                arr2[i][j] = value;
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr1[i][j] != 'C') {
                    char target = arr1[i][j];
                    arr1[i][j] = 'C';
                    answer++;
                    bfs(i, j, target, arr1);
                }
            }
        }
        sb.append(answer).append(" ");
        answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr2[i][j] != 'C') {
                    char target = arr2[i][j];
                    arr2[i][j] = 'C';
                    answer++;
                    bfs(i, j, target, arr2);
                }
            }
        }
        sb.append(answer);

        System.out.println(sb);
    }

    private static void bfs(int x, int y, char target, char[][] arr) {
        q.offer(new Point(x, y));

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] != 'C' && arr[nx][ny] == target) {
                    q.offer(new Point(nx, ny));
                    arr[nx][ny] = 'C';
                }
            }
        }
    }
}
