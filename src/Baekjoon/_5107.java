package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class _5107 {
    static List<List<Integer>> list;
    static boolean[] visited;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            visited = new boolean[n];

            HashMap<String, Integer> map = new HashMap<>();
            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new ArrayList<>());
            }

            int id = 0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!map.containsKey(a)) {
                    map.put(a, id++);
                }
                if (!map.containsKey(b)) {
                    map.put(b, id++);
                }
                list.get(map.get(a)).add(map.get(b));
            }

            cnt = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(i);
                }
            }
            sb.append(t).append(" ").append(cnt).append("\n");
            t++;
        }
        System.out.print(sb);
    }

    static void dfs(int start) {
        for (int next : list.get(start)) {
            if (visited[next]) {
                cnt++;
                return;
            }
            visited[next] = true;
            dfs(next);
        }
    }
}
