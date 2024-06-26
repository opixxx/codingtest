package Baekjoon.dfs_bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _2667 {
    static int n;
    static int[][] board;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer = 0;
    static ArrayList<Integer> arr = new ArrayList<>();
    public void DFS(int x, int y, int[][] board) {
        board[x][y] = 0;
        answer++;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                DFS(nx, ny, board);
            }
        }

    }

    public void solution(int[][] board) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer = 0;
                    DFS(i, j, board);
                    arr.add(answer);
                }
            }
        }

    }
    public static void main(String[] args) {
        _2667 T = new _2667();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        T.solution(board);
        Collections.sort(arr);
        System.out.println(arr.size());
        for(int x : arr) {
            System.out.println(x);
        }
    }
}
