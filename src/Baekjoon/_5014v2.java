package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5014v2 {
    static int f, s, g, u, d;
    static int[] nextFloor;
    static boolean[] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        ch =new boolean[f + 1];

        nextFloor = new int[2];
        nextFloor[0] = u;
        nextFloor[1] = -d;

        int answer = bfs();
        if (answer == -1) {
            System.out.print("use the stairs");
        } else {
            System.out.print(answer);
        }
    }

    private static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        ch[s] = true;
        q.offer(new Pair(s, 0));

        while (!q.isEmpty()) {
            var cur = q.poll();

            if (cur.floor == g) {
                return cur.count;
            }

            for (int i = 0; i < 2; i++) {
                int nf = cur.floor + nextFloor[i];

                if (nf <= f && nf >= 1&& nf != cur.floor && !ch[nf]) {
                    ch[nf] =true;
                    q.offer(new Pair(nf, cur.count + 1));
                }
            }
        }
        return -1;
    }

    static class Pair {
        int floor;
        int count;

        public Pair(int floor, int count) {
            this.floor = floor;
            this.count = count;
        }
    }
}
