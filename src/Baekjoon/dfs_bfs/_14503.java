package Baekjoon.dfs_bfs;

import java.util.Scanner;

public class _14503 {
    static int[][] room;
    static int answer = 0;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1}; // 북동남서
    static int n,m,r,c,d;

    public void solution(int x, int y, int d) {
        room[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 주변 4칸 중 청소 가능한 칸이 있을 경우
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] == 0) {
                answer++;
                solution(nx, ny, d);
                return;
            }
        }
        int back = (d + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];
        if(bx >= 0 && bx < n && by >= 0 && by < m && room[bx][by] != 1) {
            solution(bx, by, d);
        }
    }
        public static void main (String[]args){
            _14503 T = new _14503();
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            m = sc.nextInt();
            r = sc.nextInt();
            c = sc.nextInt();
            d = sc.nextInt();
            room = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    room[i][j] = sc.nextInt();
                }
            }
            room[r][c] = -1;
            T.solution(r, c, d);
            System.out.println(answer + 1);
    }
}
