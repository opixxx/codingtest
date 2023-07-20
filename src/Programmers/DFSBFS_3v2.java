package Programmers;
import java.util.*;
class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class DFSBFS_3v2 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] dis;
    public void BFS(int x, int y, int[][] maps) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        maps[0][0] = 0;
        while(!q.isEmpty()) {
            Point tmp = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx <= maps.length -1 && ny >= 0 && ny <= maps[0].length-1 && maps[nx][ny] == 1){
                    maps[nx][ny] = 0;
                    q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }
    public int solution(int[][] maps) {
        dis = new int[maps.length][maps[0].length];
        dis[0][0] = 1;
        int answer = 0;
        BFS(0,0, maps);
        if(dis[maps.length - 1][maps[0].length - 1] == 0) return -1;
        return dis[maps.length - 1][maps[0].length - 1];
    }
}