package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _13256 {
    static List<List<Integer>> list;
    static int[] color;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.get(x).add(y);
                list.get(y).add(x);
            }
            color = new int[n + 1];

            flag = true;
            for (int i = 1; i <= n; i++) {
                if (color[i] == 0) {
                    bfs(i);
                }
                if (!flag) {
                    break;
                }
            }

            if (!flag) {
                sb.append("impossible\n");
            } else {
                sb.append("possible\n");
            }

        }
        System.out.print(sb);


    }
    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        color[start] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : list.get(cur)) {
                if (color[next] == 0) { // 색칠 X
                    q.offer(next);
                    color[next] = -color[cur];
                } else if (color[cur] + color[next] != 0) {
                    flag = false;
                    return;
                }
            }
        }

    }
}
