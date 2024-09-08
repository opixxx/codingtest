package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _11725 {
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        int[] ch = new int[n + 1];
        int[] answer = new int[n + 1];

        Queue<Integer> q = new ArrayDeque<>();

        q.add(1);
        ch[1] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int child : list.get(cur)) {
                if (ch[child] == 0) {
                    ch[child] = 1;
                    q.add(child);
                    answer[child] = cur;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(answer[i]);
        }

    }
}
