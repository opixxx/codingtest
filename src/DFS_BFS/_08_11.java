package DFS_BFS;

import java.util.Scanner;

public class _08_11 {
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1}; // 좌, 상, 우, 하
    static int answer = Integer.MAX_VALUE;
    public void BFS(int L, int x, int y) {
        if (L >= answer) return;
        if (x == 7 && y == 7) {
            answer = Math.min(answer, L);
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i]; // 좌상우하
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    BFS(L + 1, nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }

    }
    public static void main(String[] args) {
        _08_11 T = new _08_11();
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        board[1][1] = 1;
        T.BFS(0,1,1);
        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }
}
