package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _20007 {
    static List<List<House>> list;
    static int n, m, x, y;
    static int[] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        dis = new int[n];

        Arrays.fill(dis, Integer.MAX_VALUE);

        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(start).add(new House(end, cost));
            list.get(end).add(new House(start, cost));
        }

        dijkstra(y);

        for (int i = 0; i < n; i++) {
            int tmp = dis[i];
            dis[i] = tmp * 2;
        }
        Arrays.sort(dis);

        if (dis[n - 1] > x) {
            System.out.println(-1);
        } else {
            int answer = 0;
            int idx = 0;
            int distance = 0;
            while (idx < n) {
                while (idx < n && dis[idx] + distance <= x) {
                    distance += dis[idx];
                    idx++;
                }
                distance = 0;
                answer++;
            }
            System.out.println(answer);

        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<House> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        dis[start] = 0;
        pq.offer(new House(start, 0));

        while (!pq.isEmpty()) {
            House cur = pq.poll();
            int curEnd = cur.end;
            int curCost = cur.cost;

            if (curCost > dis[curEnd]) continue;
            for (House house : list.get(curEnd)) {
                int nextEnd = house.end;
                int nextCost = house.cost;

                if (dis[nextEnd] > curCost + nextCost) {
                    dis[nextEnd] = curCost + nextCost;
                    pq.offer(new House(nextEnd, curCost + nextCost));
                }
            }
        }
    }

    static class House {
        int end;
        int cost;

        public House(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
