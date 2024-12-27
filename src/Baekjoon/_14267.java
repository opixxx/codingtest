package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _14267 {
    static List<List<Integer>> list;
    static int n, m;
    static int[] score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        score = new int[n + 1];

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int boss = 1; boss <= n; boss++) {
            int a = Integer.parseInt(st.nextToken());
            if (a == -1) continue;
            list.get(a).add(boss);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int employee = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            score[employee] += w;
        }

        dfs(1);
        for (int i = 1; i <= n; i++) {
            System.out.print(score[i] + " ");
        }
    }

    static void dfs(int start) {
        for (int node : list.get(start)) {
            score[node] += score[start];
            dfs(node);
        }
    }
}
