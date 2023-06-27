package DFS_BFS;

import java.util.Scanner;

public class _08_07 {
    static int n, r, answer = 0;
    public void DFS(int n, int r) {
        if (n == r) answer += 1;
        if (r == 1 || ((n - r) == 1)) {
            answer += n;
        }
        else {
            DFS(n - 1, r - 1);
            DFS(n - 1, r);


        }

    }
    public static void main(String[] args) {
        _08_07 T = new _08_07();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        T.DFS(n, r);
        System.out.println(answer);
    }
}
