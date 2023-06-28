package DFS_BFS;

import java.util.Scanner;

public class _08_09 {
    static int n, m;
    //int[][] dy = new int[15][15];
    static int[] ans;

    public void DFS(int L, int s) {
        if (L == m){
            for (int x : ans) System.out.print(x + " ");
            System.out.println();

        } else {
            for (int i = s; i <= n; i++) {
                ans[L] = i;
                DFS(L + 1, s + i);

            }
        }
    }


    public static void main(String[] args) {
        _08_09 T = new _08_09();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ans = new int[m];
        T.DFS(0, 1);
    }
}
