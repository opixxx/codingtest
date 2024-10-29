package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _9205 {
    static int startX;
    static int startY;
    static int targetX;
    static int targetY;
    static List<int[]> list;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine()); //편의점 수
            list = new ArrayList<>();
            for (int j = 0; j < n + 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (j == 0) {
                    startX = x;
                    startY = y;
                } else if (j == n + 1) {
                    targetX = x;
                    targetY = y;
                } else {
                    list.add(new int[]{x, y});
                }
            }

            if (bfs()) {
                sb.append("happy\n");
            } else {
                sb.append("sad\n");
            }

        }
        System.out.println(sb);
    }

    private static boolean bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] ch = new boolean[n];
        q.offer(new int[]{startX, startY});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            if (Math.abs(curX - targetX) + Math.abs(curY - targetY) <= 1000) {
                return true;
            }

            for (int i = 0; i < n; i++) {
                if (!ch[i]) {
                    int[] store = list.get(i);
                    int storeX = store[0];
                    int storeY = store[1];
                    int dis = Math.abs(curX - storeX) + Math.abs(curY - storeY);
                    if (dis <= 1000) {
                        ch[i] = true;
                        q.offer(new int[]{storeX, storeY});
                    }
                }
            }
        }
        return false;



    }
}
