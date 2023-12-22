package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// M 개의 치킨 집을 구하는 DFS
// 각 집의 치킨 거리 구하기
// 도시의 치킨 거리의 합

public class _15686 {
    static List<Point> house;
    static List<Point> chicken;
    static int[] combi;

    static int n, m, len;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1) {
                    house.add(new Point(i, j));
                }
                else if (tmp == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }
        combi = new int[m];
        len = chicken.size();

        DFS(0, 0);
        System.out.println(answer);

    }

    private static void DFS(int L, int s) {
        if (L == m) {
            int sum = 0;
            for (Point h : house) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(h.x - chicken.get(i).x) + Math.abs(h.y - chicken.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);

        } else {
            for (int i = s; i < len ; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }
}
