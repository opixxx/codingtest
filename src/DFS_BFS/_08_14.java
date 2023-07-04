package DFS_BFS;

import java.util.ArrayList;
import java.util.Scanner;

public class _08_14 {
    static int n, m, len, answer = Integer.MAX_VALUE;
    static int[][] city;
    static int[] combi;
    static ArrayList<Point> hs, pz;
    public void DFS(int L, int s) {
        if (L == m) {
            int sum = 0;
            for(Point h : hs) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);

        } else {
            for (int i = s; i < len ; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }


    }

    public static void main(String[] args) {
        _08_14 T = new _08_14();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pz = new ArrayList<>();
        hs = new ArrayList<>();
        city = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                city[i][j] = sc.nextInt();
                if (city[i][j] == 1) hs.add(new Point(i, j));
                if (city[i][j] == 2) pz.add(new Point(i, j));
            }
        }
        combi = new int[m];
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
