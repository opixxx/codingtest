package DFS_BFS;

import java.util.Scanner;

public class _08_06 {
    static int n, m;
    static int[] arr, pm, ch;
    public void DFS(int L) {
        if (L == m) {
            for (int x : pm) System.out.print(x + " ");
            System.out.println();

        }else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }

        }


    }
    public static void main(String[] args) {
        _08_06 T = new _08_06();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ch = new int[n];
        arr = new int[n];
        pm = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        T.DFS(0);
    }
}

