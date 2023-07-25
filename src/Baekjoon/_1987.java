package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class _1987 {
    static int r, c;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] board;
    static int[] ch;
    static int max = Integer.MIN_VALUE;
    public void DFS(int L, int x, int y) {
        max =Math.max(max, L);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < r && ny >= 0 && ny < c && ch[board[nx][ny]] == 0) {
                ch[board[nx][ny]] = 1;
                DFS(L + 1, nx, ny);
                ch[board[nx][ny]] = 0;
            }
        }

    }
    public static void main(String[] args) {
        _1987 T = new _1987();
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();//3
        c = sc.nextInt();//6
        ch = new int[26];
        board = new int[r][c];
        for (int i = 0; i < r; i++) {
            String str = sc.next();
            for (int j = 0; j < c; j++) {
                board[i][j] = str.charAt(j) - 'A';
            }
        }
        ch[board[0][0]] = 1;
        T.DFS(1, 0,0);
        System.out.println(max);


    }

}
