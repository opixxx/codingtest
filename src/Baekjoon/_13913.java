package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class _13913 {
    static int n, k, answer;
    static int[] ch = new int[100001];
    static int[] parent = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
            System.out.println(n);
            return;
        }

        BFS(n);

        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        int idx = k;

        while (idx != n) {
            stack.push(parent[idx]);
            idx = parent[idx];
        }
        System.out.println(answer);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void BFS(int n) {

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        ch[n] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 0) {
                    nx = cur + 1;
                } else if (i == 1) {
                    nx = cur - 1;
                } else {
                    nx = cur * 2;
                }

                if (nx == k) {
                    answer = ch[cur];
                    parent[nx] = cur;
                    return;
                }

                if (nx >= 0 && nx <= 100000 && ch[nx] == 0) {
                    q.add(nx);
                    ch[nx] = ch[cur] + 1;
                    parent[nx] = cur;
                }
            }
        }
    }
}
