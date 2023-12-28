package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _14620 {
    static int n;
    static double dis = Math.sqrt(5);
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static int[][] ch;
    static int answer = Integer.MAX_VALUE;
    static List<Point> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        ch = new int[n][n];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                list.add(new Point(i, j));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    Point a = list.get(i);
                    Point b = list.get(j);
                    Point c = list.get(k);
                    DFS(a, b, c);
                }
            }
        }
        System.out.println(answer);

    }

    private static void DFS(Point a, Point b, Point c) {
        if (!isRange(a) || !isRange(b) || !isRange(c)) {
            return;
        }

        double len1 = Math.sqrt(getDistance(a, b));
        double len2 = Math.sqrt(getDistance(a, c));
        double len3 = Math.sqrt(getDistance(b, c));

        if (len1 < dis || len2 < dis || len3 < dis) {
            return;
        }
        int sum = 0;
        sum = map[a.x][a.y] + map[b.x][b.y] + map[c.x][c.y];

        sum = getSum(a, sum);
        sum = getSum(b, sum);
        sum = getSum(c, sum);

        answer = Math.min(answer, sum);

    }
    private static double getDistance(Point p1, Point p2) {
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;
        return dx * dx + dy * dy;
    }

    private static int getSum(Point a, int sum) {
        for (int j = 0; j < 4; j++) {
            int nx = a.x + dx[j];
            int ny = a.y + dy[j];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                sum += map[nx][ny];
            }
        }
        return sum;
    }

    private static boolean isRange(Point p) {
        for (int i = 0; i < 4; i++) {
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                return false;
            }
        }
        return true;
    }
}
