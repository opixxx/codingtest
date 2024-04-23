package Baekjoon.DFS_BFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _2210 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static String[][] board;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new String[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = sc.next();
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                DFS(i, j, 0, board[i][j]);
            }
        }

        System.out.println(list.size());
    }

    private static void DFS(int x, int y, int L, String num) {

        if (L == 5) {
            if (!list.contains(num)) {
                list.add(num);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                DFS(nx, ny, L + 1, num + board[nx][ny]);
            }
        }
    }
}
