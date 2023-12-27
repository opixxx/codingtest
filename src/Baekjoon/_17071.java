package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class _17071 {
    static int n, k;
    static boolean[][] visited = new boolean[500001][2];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println(0);
            return;
        }
        int bfs = BFS(n);
        System.out.println(bfs);
    }

    public static int BFS(int n) {
        Queue<Integer> q = new LinkedList<>();
        int time = 0;
        q.offer(n);
        visited[n][time] = true;
        while (!q.isEmpty()) {

            if (k > 500000) {
                return -1;
            }

            int isEvenOdd = time % 2; // time 이 홀수인지 짝수인지

            if (visited[k][isEvenOdd]) {
                return time;
            }

            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int now = q.poll();

                int nextTime = (time + 1) % 2;
                int next;

                next = now - 1;
                if (next >= 0 && !visited[next][nextTime]) {
                    visited[next][nextTime] = true;
                    q.offer(next);
                }
                next = now + 1;
                if (next <= 500000 && !visited[next][nextTime]) {
                    visited[next][nextTime] = true;
                    q.offer(next);
                }
                next = now * 2;
                if (next <= 500000 && !visited[next][nextTime]) {
                    visited[next][nextTime] = true;
                    q.offer(next);
                }
            }
            time++;
            k += time;
        }
        return -1;
    }

}
