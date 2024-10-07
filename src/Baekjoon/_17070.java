package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17070 {
    static int n;
    static int[][] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 2, 0);
        System.out.println(answer);

    }

    static void dfs(int x, int y, int dir) {
        if (x == n && y == n) {
            answer++;
            return;
        }

        if (dir == 0) { //가로
            if (y + 1 <= n && arr[x][y + 1] == 0) {
                dfs(x, y + 1, 0);
            }
            if (x + 1 <= n && y + 1 <= n && arr[x + 1][y + 1] == 0 && arr[x][y+1] ==0 && arr[x+1][y] == 0) {
                dfs(x + 1, y + 1, 2);
            }
        }

        if (dir == 1) { //세로
            if (x + 1 <= n && arr[x + 1][y] == 0) {
                dfs(x + 1, y, 1);
            }
            if (x + 1 <= n && y + 1 <= n && arr[x + 1][y + 1] == 0 && arr[x][y+1] ==0 && arr[x+1][y] == 0) {
                dfs(x + 1, y + 1, 2);
            }
        }

        if (dir == 2) { //대각
            if (y + 1 <= n && arr[x][y + 1] == 0) {
                dfs(x, y + 1, 0);
            }
            if (x + 1 <= n && arr[x + 1][y] == 0) {
                dfs(x + 1, y, 1);
            }
            if (x + 1 <= n && y + 1 <= n && arr[x + 1][y + 1] == 0 && arr[x][y+1] ==0 && arr[x+1][y] == 0) {
                dfs(x + 1, y + 1, 2);
            }
        }
    }
}
