package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class _20165 {
    static int[][] domino;
    static char[][] map;
    static int[] dx = {0, 0, 1, -1}; // 동서남북
    static int[] dy = {1, -1, 0, 0};
    static int n, m;
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        domino = new int[n][m];
        map = new char[n][m];
        for (char[] rows : map) {
            Arrays.fill(rows, 'S');
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                domino[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (r-- > 0) {
            st = new StringTokenizer(br.readLine());

            int attackX = Integer.parseInt(st.nextToken()) - 1;
            int attackY = Integer.parseInt(st.nextToken()) - 1;
            int dir = changeDir(st.nextToken().charAt(0));

            st = new StringTokenizer(br.readLine());
            int defenseX = Integer.parseInt(st.nextToken()) - 1;
            int defenseY = Integer.parseInt(st.nextToken()) - 1;

            if (map[attackX][attackY] == 'S') { // 1 -> 도미노 세워져 있는거
                map[attackX][attackY] = 'F';
                answer += attack(attackX, attackY, dir);

            }
            map[defenseX][defenseY] = 'S';
        }

        System.out.println(answer);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int attack(int attackX, int attackY, int dir) {

        int result = 1;
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(attackX, attackY));
        while (!q.isEmpty()) {
            Point cur = q.poll();

            int dominoHigh = domino[cur.x][cur.y];

            int nx = cur.x;
            int ny = cur.y;
            for (int i = 1; i < dominoHigh; i++) {
                nx += dx[dir];
                ny += dy[dir];

                if (!isRange(nx, ny)) break;
                if (map[nx][ny] == 'F') continue;

                map[nx][ny] = 'F';
                q.offer(new Point(nx, ny));
                result++;
            }
        }
        return result;
    }
    static int changeDir(char dir) {
        if (dir == 'E') {
            return 0;
        } else if (dir == 'W') {
            return 1;
        } else if (dir == 'S') {
            return 2;
        } else {
            return 3;
        }
    }

    static boolean isRange(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
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
