package DFS_BFS;

import java.util.Scanner;

public class _08_08 {
    static int n, f;
    static int[] b, p, ch; // 조합 값을 넣어 놓는 배열
    int[][] dy = new int[15][15];
    boolean flag = false;
    public int combi(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        else return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
    public void DFS(int L, int sum) {
        if (flag) return;
        if (L == n) {
            if (sum == f) {
                for (int x : p) System.out.print(x + " ");
                flag = true;
            }

        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[L] = i;
                    DFS(L + 1, sum + p[L] * b[L]);
                    ch[i] = 0;
                }
            }
        }



    }
    public static void main(String[] args) {
        _08_08 T = new _08_08();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n + 1];
        for (int i = 0; i < n; i++) {
            b[i] = T.combi(n - 1, i);
        }
        T.DFS(0, 0);

    }
}
