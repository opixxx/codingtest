package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class _14502 {
    static int n, m, answer;
    static int[][] board;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void BFS() {
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    q.add(new Node(i, j));
                }
            }
        }
        int[][] tmp = new int[n][m];

        for (int i = 0; i < n; i++) {
            tmp[i] = board[i].clone();
        }

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && tmp[nx][ny] == 0) {
                    q.add(new Node(nx, ny));
                    tmp[nx][ny] = 2;
                }
            }
        }
        CountSafeZone(tmp);

    }


    public static void DFS(int wallCount) {
        if (wallCount == 3) {
            BFS();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    DFS(wallCount + 1);
                    board[i][j] = 0;
                }
            }
        }
    }
    private static void CountSafeZone(int[][] tmp) {
        int safeZone = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        answer = Math.max(safeZone, answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][m];
        answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        DFS(0);

        System.out.println(answer);

    }
}
