package Baekjoon.DFS_BFS;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _2583 {
    static int[][] board;
    static int m,n,k;
    static ArrayList<Integer> arr = new ArrayList<>();
    static int answer;
    static int[] dx = {1, -1, 0, 0,};
    static int[] dy = {0, 0, 1, -1,};
    public void DFS(int x, int y, int[][] board) {
        board[x][y] = 1;
        answer++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 0) {

                DFS(nx, ny, board);
            }
        }
    }
    public void solution(int[][] board) {

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
                if(board[i][j] == 0) {
                    answer = 0;
                    DFS(i, j, board);
                    arr.add(answer);
                }

            }
        }

    }
    public static void main(String[] args) {
        _2583 T = new _2583();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();
        board = new int[m][n];

        for (int i = 0; i < k; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for (int j = y1; j < y2 ; j++) {
                for (int l = x1; l < x2 ; l++) {
                    board[j][l] = 1;
                }
            }
        }
        T.solution(board);
        Collections.sort(arr);
        System.out.println(arr.size());
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }
}
