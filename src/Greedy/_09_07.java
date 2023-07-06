package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Edge implements Comparable<Edge> {
    public int v1, v2, cost;
    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
public class _09_07 {
    static int[] unf;
    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }
    public static int Find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) unf[i] = i;
        ArrayList<Edge> arr = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Edge(a, b, c));
        }
        int answer = 0;
        int cnt = 0;
        Collections.sort(arr);
        for (Edge ob : arr) {
            int find_v1 = Find(ob.v1);
            int find_v2 = Find(ob.v2);
            if (find_v1 != find_v2) { // 같은 집합이 아니면 cost 를 answer 에 누적
                answer += ob.cost;
                Union(ob.v1, ob.v2); // 도시 2개를 한 집합으로 묶음
                cnt++;
            }
            if (cnt == n - 1) break;
         }
        System.out.println(answer);
    }
}
