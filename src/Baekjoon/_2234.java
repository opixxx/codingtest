package Baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2234 {
    static int n, m;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] map;
    static boolean[][] visited;
    static int[][][] wallCount;
    static int roomCount = 0;
    static int maxRoom = Integer.MIN_VALUE;
    static int removeWallRoom = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[m][n];
        visited = new boolean[m][n];
        wallCount = new int[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i,j, roomCount);
                    roomCount++;
                }
            }
        }
        getMaxRoom();
        System.out.println(roomCount);
        System.out.println(maxRoom);
        System.out.println(removeWallRoom);
    }

    public static void bfs(int x, int y, int roomId) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        ArrayList<Point> temp = new ArrayList<>();

        int tempRoom = 0;
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            tempRoom++;
            temp.add(new Point(cur.x, cur.y));

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];


                if ((map[cur.x][cur.y] & (1 << i)) == 0) { // 벽이 없는 경우

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                        q.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        maxRoom = Math.max(maxRoom, tempRoom);

        for (Point p : temp) {
            wallCount[p.x][p.y][0] = roomId;
            wallCount[p.x][p.y][1] = tempRoom;
        }
    }

    public static void getMaxRoom() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {

                        if (wallCount[i][j][0] != wallCount[nx][ny][0]) {
                            removeWallRoom = Math.max(removeWallRoom, wallCount[i][j][1] + wallCount[nx][ny][1]);
                        }
                    }
                }
            }
        }
    }
}
