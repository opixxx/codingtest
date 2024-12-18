package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _3190 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0}; // 동 서 남 북
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        int apple = Integer.parseInt(br.readLine());

        for (int i = 0; i < apple; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            board[a][b] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        HashMap<Integer, String> map = new HashMap<>();

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            map.put(sec, dir);
        }

        int count = 0;
        int direction = 0; // 0 1 2 3 동 서 남 북
        Deque<Point> q = new ArrayDeque<>();
        q.offerLast(new Point(0, 0));
        while (true) {
            count++;
            Point cur = q.peekLast();

            int nx = cur.x + dx[direction];
            int ny = cur.y + dy[direction];

            if (isEnd(q, nx, ny)) {
                break;
            }

            if (board[nx][ny] == 1) {
                board[nx][ny] = 0;
                q.offer(new Point(nx, ny));
            } else {
                q.offer(new Point(nx, ny));
                q.pollFirst();
            }

            if (map.containsKey(count)) {
                if (map.get(count).equals("D")) {
                    direction += 1;
                    if (direction == 4) {
                        direction = 0;
                    }
                } else {
                    direction -= 1;
                    if (direction == -1) {
                        direction = 3;
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isEnd(Deque<Point> q, int nx, int ny) {
        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
            return true;
        }

        for (Point point : q) {
            if (point.x == nx && point.y == ny) {
                return true;
            }
        }
        return false;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
