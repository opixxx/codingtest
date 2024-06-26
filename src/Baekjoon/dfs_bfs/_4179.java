package Baekjoon.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x, y, time;

    public Point(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class _4179 {
    static char[][] board;
    static int r, c, answer;
    static Queue<Point> fire; //불
    static Queue<Point> jh; //지훈
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1}; // 하우상좌

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        board = new char[r][c];
        fire = new LinkedList<>();
        jh = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            String str = sc.next();
            for (int j = 0; j < c; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'J') {
                    jh.offer(new Point(i, j, 0));
                }
                if (board[i][j] == 'F') {
                    fire.offer(new Point(i, j, 0));
                }
            }
        }
        answer = 0;

        if(bfs()) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(answer);
        }
    }

    public static boolean bfs() {
        // 불 먼저
        while(!jh.isEmpty()) {
            int f_size = fire.size();
            for(int i=0;i<f_size;i++) {
                Point node = fire.poll();

                for(int d=0;d<4;d++) {
                    int nx = node.x + dx[d];
                    int ny = node.y + dy[d];
                    if(0 <= nx && nx < r && 0 <= ny && ny < c) {
                        if(board[nx][ny] != '#' && board[nx][ny] !='F') {
                            board[nx][ny] = 'F';
                            fire.add(new Point(nx, ny, node.time+1));
                        }
                    }
                }

            }

            int j_size = jh.size();

            for(int i=0;i<j_size;i++) {
                Point node = jh.poll();

                for(int d=0;d<4;d++) {
                    int nx = node.x + dx[d];
                    int ny = node.y + dy[d];
                    if(nx < 0 || nx >= r || ny < 0 || ny >= c) {
                        answer = node.time+1;
                        return false;
                    }


                    if(board[nx][ny] != '#' && board[nx][ny] !='F' && board[nx][ny] != 'J') {
                        jh.add(new Point(nx, ny, node.time+1));
                        board[nx][ny] = 'J';
                    }

                }

            }

        }
        return true;

    }

}
