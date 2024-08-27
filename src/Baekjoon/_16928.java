package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class _16928 {

    static Queue<int []> q = new ArrayDeque<>();
    static int n, m;
    static Map<Integer, Integer> ladder = new HashMap<>();
    static Map<Integer, Integer> snakes = new HashMap<>();
    static int[] ch = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 사다리
        m = Integer.parseInt(st.nextToken()); // 뱀

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            ladder.put(start, end);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            snakes.put(start, end);
        }
        q.offer(new int[]{1, 0});

        bfs();
    }

    private static void bfs() {

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curPosition = cur[0];
            int curCount = cur[1];

            if (curPosition == 100) {
                System.out.println(curCount);
            }

            for (int i = 1; i <= 6; i++) {
                int next = curPosition + i;

                if (next > 100) {
                    continue;
                }

                if (ladder.containsKey(next)) {
                    next = ladder.get(next);
                } else if (snakes.containsKey(next)) {
                    next = snakes.get(next);
                }
                if (ch[next] != 1) {
                    ch[next] = 1;
                    q.offer(new int[]{next, curCount + 1});

                }
            }

        }


    }
}
