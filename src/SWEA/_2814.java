package SWEA;

import java.util.Scanner;

public class _2814 {
    static int[][] map;
    static int[] ch;
    static int n, m;
    static int max;
    public static void DFS(int node, int cnt) {
        ch[node] = 1;
        for (int i = 1; i <= n; i++) {

            if (node == i) continue;
            if (map[node][i] == 1 && ch[i] == 0) {
                DFS(i, cnt + 1);
                ch[i] = 0;
            }
        }
        max = Math.max(max, cnt);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            max = Integer.MIN_VALUE;
            n = sc.nextInt();
            m = sc.nextInt();
            ch = new int[n + 1];
            map = new int[n + 1][n + 1];
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = map[y][x] = 1;
            }
            for (int i = 1; i <= n; i++) {
                DFS(i, 1);
                ch[i] = 0;
            }
            if (max == Integer.MIN_VALUE) {
                System.out.println("#" + t + " " + 1);
            } else {
                System.out.println("#" + t + " " + max);
            }
        }

    }
}
