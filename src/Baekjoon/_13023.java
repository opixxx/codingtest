package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _13023 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] ch;
    static int n;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            ch = new boolean[n];
            dfs(i, 0);
        }
        System.out.println(answer);

    }

    private static void dfs(int start, int level) {
        if (level == 4) {
            answer = 1;
            return;
        }
        ch[start] = true;
        for (int cur : list.get(start)) {
            if (!ch[cur]) {
                ch[cur] = true;
                dfs(cur, level + 1);
            }
        }
        ch[start] = false;
    }
}
