package Baekjoon.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Floor {
    public int floor, count;
    Floor(int floor, int count) {
        this.floor = floor;
        this.count = count;
    }
}


public class _5014 {
    static int[] ch;
    static int f,s,g,u,d;
    static int answer;
    public void BFS(int level, int cnt) {

        Queue<Floor> q = new LinkedList<>();
        q.offer(new Floor(level, cnt));
        while(!q.isEmpty()) {
            Floor tmp = q.poll();
            if (tmp.floor == g) {
                answer = tmp.count;
                break;
            }
            for (int i = 0; i < 2; i++) {
                int D = tmp.floor + u;
                int U = tmp.floor - d;
                if (D > 0 && D <= f && ch[D] == 0) {
                    ch[D] = 1;
                    q.offer(new Floor(D,tmp.count + 1));
                }
                if (U > 0 && U <= f && ch[U] == 0) {
                    ch[U] = 1;
                    q.offer(new Floor(U, tmp.count + 1));
                }

            }
        }
    }
    public static void main(String[] args) {
        _5014 T = new _5014();
        Scanner sc = new Scanner(System.in);
        f = sc.nextInt();
        s = sc.nextInt();
        g = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        ch = new int[f + 1];
        T.BFS(s, 0);
        if (g == s) {
            answer = 0;
            System.out.println(answer);
            return;
        }
        if (ch[g] == 0) {
            System.out.println("use the stairs");
        }
        else System.out.println(answer);
    }
}
