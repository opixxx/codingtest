package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17220 {
    static List<List<Integer>> list1;
    static List<List<Integer>> list2;
    static int[] ch = new int[26]; // 검거된 마약 운반
    static int[] visited = new int[26]; // 방문 체크
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list1.add(new ArrayList<>());
            list2.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'A';
            int b = st.nextToken().charAt(0) - 'A';

            list1.get(a).add(b);
            list2.get(b).add(a);
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            char a = st.nextToken().charAt(0);
            ch[a - 'A'] = 1;
        }

        List<Integer> rootNode = getRootNode();
        for (int root : rootNode) {
            bfs(root);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int root) {
        if (ch[root] == 1) {
            return;
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nextNode : list1.get(cur)) {
                if (ch[nextNode] == 1 || visited[nextNode] == 1) {
                    continue;
                }
                q.offer(nextNode);
                visited[nextNode] = 1;
            }
        }
    }

    private static List<Integer> getRootNode() {
        List<Integer> rootNode = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (list2.get(i).isEmpty()) {
                rootNode.add(i);
            }
        }
        return rootNode;
    }
}
