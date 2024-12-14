package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _16168 {

    static List<List<Integer>> list;
    static int[][] ch;
    static int v, e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        ch = new int[v + 1][v + 1];
        list = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }



        int odd = 0;
        int even = 0;
        for (int i = 1; i <= v; i++) {
            int a = list.get(i).size();
            if (a % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        if (isConnected() && (even == v || odd == 2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isConnected() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        int[] ch = new int[v + 1];

        ch[1] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : list.get(cur)) {
                if (ch[next] == 0) {
                    ch[next] = 1;
                    q.offer(next);
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (ch[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
