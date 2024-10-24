package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _6118 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static Queue<Node> q = new ArrayDeque<>();
    static boolean[] ch;
    static int max = Integer.MIN_VALUE;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //노드
        int m = Integer.parseInt(st.nextToken()); //간선

        answer = new int[n + 1];
        ch = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }
        bfs();
        int cnt = 0;
        int maxFirstIdx = 0;
        for (int i = 1; i <= n; i++) {
            if (max == answer[i]) {
                if (maxFirstIdx == 0) {
                    maxFirstIdx = i;
                }
                cnt++;
            }
        }

        System.out.println(maxFirstIdx + " " + max + " " + cnt);

    }

    private static void bfs() {
        q.offer(new Node(1, 0));
        ch[1] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            max = Math.max(max, cur.len);
            answer[cur.v] = max;

            for (Integer nextV : list.get(cur.v)) {
                if (ch[nextV]) continue;

                q.offer(new Node(nextV, cur.len + 1));
                ch[nextV] = true;
            }
        }
    }

    static class Node {
        int v;
        int len;

        public Node(int v, int len) {
            this.v = v;
            this.len = len;
        }
    }
}
