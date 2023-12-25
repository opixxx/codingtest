package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697 {
    static int n, k;
    static int[] ch = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        BFS(n);
    }
    public static void BFS(int n) {

        if (n == k) {
            System.out.println(0);
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        ch[n] = 1;
        q.add(n);

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 0) {
                    nx = temp - 1;
                } else if (i == 1) {
                    nx = temp + 1;
                } else {
                    nx = temp * 2;
                }

                if (nx == k) {
                    System.out.println(ch[temp]);
                    return;
                }
                if (nx >= 0 && nx < ch.length && ch[nx] == 0) {
                    q.add(nx);
                    ch[nx] = ch[temp] + 1;
                }
            }
        }
    }
}
