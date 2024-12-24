package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _17089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        boolean[][] isFriend = new boolean[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
            isFriend[a][b] = true;
            isFriend[b][a] = true;
        }

        int count = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int a : list.get(i)) {
                for (int b : list.get(a)) {
                    if (isFriend[i][b]) {
                        int tmp = list.get(i).size() + list.get(a).size() + list.get(b).size() - 6;
                        count = Math.min(count, tmp);
                    }
                }
            }
        }
        System.out.println(count == Integer.MAX_VALUE ? -1 : count);
    }
}
