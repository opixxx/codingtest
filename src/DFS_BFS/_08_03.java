package DFS_BFS;

import java.util.Scanner;

public class _08_03 {
    static int n, m, answer = 0;

    public void DFS(int L, int score, int time, int[] a, int[] b) {
        if (time > m) return;
        if (L == n){
            answer = Math.max(answer, score);
        }else {
            DFS(L + 1, score + a[L], time + b[L], a, b);
            DFS(L + 1, score, time, a, b);
        }


    }
    public static void main(String[] args) {
        _08_03 T = new _08_03();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        T.DFS(0, 0, 0, a, b);
        System.out.println(answer);
    }
}
