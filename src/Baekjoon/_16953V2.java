package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16953V2 {
    static Queue<long[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long answer = bfs(n, m);
        System.out.println(answer);
    }

    private static long bfs(long n, long m) {
        q.offer(new long[]{n, 1});

        while (!q.isEmpty()) {
            long[] poll = q.poll();
            long curVal = poll[0];
            long level = poll[1];

            if (curVal == m) {
                return level;
            }
            if (curVal * 2 <= m) {
                q.offer(new long[]{curVal * 2, level + 1});
            }

            if (curVal * 10 + 1 <= m) {
                q.offer(new long[]{curVal * 10 + 1, level + 1});
            }

        }

        return -1;
    }
}
