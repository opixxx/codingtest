package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _13549 {
    static int n, m;
//    static int min = Integer.MAX_VALUE;
    static int[] ch = new int[100001];
    static Queue<Position> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        System.out.println(bfs());

    }

    private static int bfs() {
        q.offer(new Position(n, 0));
        ch[n] = 1;
        if (n == m) {
            return 0;
        }

        while (!q.isEmpty()) {
            Position poll = q.poll();
            int curPos = poll.pos;
            int curTime = poll.time;

            int nextPos1 = curPos - 1;
            int nextPos2 = curPos + 1;
            int nextPos3 = curPos * 2;

            if (nextPos3 >= 0 && nextPos3 <=100000 && ch[nextPos3] == 0) {
                if (nextPos3 == m) {
                    return curTime;
                }
                ch[nextPos3] = 1;
                q.offer(new Position(nextPos3, curTime));
            }

            if (nextPos1 >= 0 && nextPos1 <=100000 && ch[nextPos1] == 0) {
                if (nextPos1 == m) {
                    return curTime + 1;
                }
                ch[nextPos1] = 1;
                q.offer(new Position(nextPos1, curTime + 1));
            }

            if (nextPos2 >= 0 && nextPos2 <=100000 && ch[nextPos2] == 0) {
                if (nextPos2 == m) {
                    return curTime + 1;
                }
                ch[nextPos2] = 1;
                q.offer(new Position(nextPos2, curTime + 1));
            }
        }
        return -1;

    }
    static class Position {
        int pos;
        int time;

        public Position(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }
}
