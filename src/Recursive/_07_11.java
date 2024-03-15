package Recursive;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _07_11 {
    static int n, m, answer = 0;
    static int[] ch, dis;
    static ArrayList<ArrayList<Integer>> graph;
    public void BFS(int v) {
        ch[v] = 1;
        dis[v] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int nv : graph.get(x)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    q.offer(nv);
                    dis[nv] = dis[x] + 1;
                }
            }
        }

    } 
    public static void main(String[] args) {
        _07_11 T = new _07_11();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n + 1];
        dis = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        T.BFS(1);
        for (int i = 2; i <= n; i++) System.out.println(i + " : " + dis[i]);


    }
}
