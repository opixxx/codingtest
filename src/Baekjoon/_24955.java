package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _24955 {
    static List<List<Integer>> graph;
    static boolean[] ch;
    static int[] arr;
    static final int DIV = 1_000_000_007;
    static final BigInteger BIG_DIV = new BigInteger(String.valueOf(1000000007));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            ch = new boolean[n + 1];
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dfs(a, b, String.valueOf(arr[a] % DIV));
        }
        System.out.println(sb);
    }

    private static void dfs(int node, int target, String value) {
        ch[node] = true;

        if (node == target) {
            BigInteger result = new BigInteger(value);
            String answer = result.remainder(BIG_DIV).toString();
            sb.append(answer).append("\n");

        }

        for (int nextNode : graph.get(node)) {
            if (!ch[nextNode]) {

                dfs(nextNode, target, value + arr[nextNode] % DIV);
            }
        }
    }
}
