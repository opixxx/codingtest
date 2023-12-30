package Baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class _17471 {
    static int n;
    static int[] population;
    static boolean[] selected;
    static boolean[] visited;
    static int abs, answer = Integer.MAX_VALUE;

    static List<ArrayList<Integer>> graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        population = new int[n];
        for (int i = 0; i < n; i++) {
            population[i] = sc.nextInt();
        }
        graph = new ArrayList<>();
        selected = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int connect = sc.nextInt();
            for (int j = 0; j < connect; j++) {
                graph.get(i).add(sc.nextInt() - 1);
            }
        }

        DFS(0);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);

        } else {
            System.out.println(answer);
        }

    }

    public static void DFS(int idx) {
        if (idx == n) {
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (selected[i]) {
                    aList.add(i);
                } else {
                    bList.add(i);
                }
            }
            if (aList.size() == 0 || bList.size() == 0) {
                return;
            }

            if (check(aList) && check(bList)) {
                getPopulation(aList, bList);
            }
            return;
        }

        selected[idx] = true;
        DFS(idx + 1);
        selected[idx] = false;
        DFS(idx + 1);

    }

    private static void getPopulation(List<Integer> aList, List<Integer> bList) {
        int pA = 0, pB = 0;
        for (int i = 0; i < aList.size(); i++) {
            pA += population[aList.get(i)];

        }
        for (int i = 0; i < bList.size(); i++) {
            pB += population[bList.get(i)];
        }
        abs = Math.abs(pA - pB);
        answer = Math.min(abs, answer);
    }

    public static boolean check(List<Integer> list) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n];

        visited[list.get(0)] = true;
        q.offer(list.get(0));
        int count = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < graph.get(cur).size(); i++) {
                int nx = graph.get(cur).get(i);
                if (list.contains(nx) && !visited[nx]) {
                    q.offer(nx);
                    visited[nx] = true;
                    count++;
                }
            }
        }
        return count == list.size();
    }
}
