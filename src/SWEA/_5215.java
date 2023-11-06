package SWEA;

import java.util.Scanner;

public class _5215 {
    static int[] cal, score;
    static int limit, n, result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            result = 0;
            n = sc.nextInt(); // 맛 갯수
            limit = sc.nextInt(); // 제한 칼로리
            score = new int[n];
            cal = new int[n];
            for (int i = 0; i < n; i++) {
                score[i] = sc.nextInt();
                cal[i] = sc.nextInt();
            }
            DFS(0, 0, 0);
            System.out.println("#" + t + " " + result);

        }
    }

    private static void DFS(int index, int calorie, int flavor) {
        if (calorie > limit) return;
        result = Math.max(result, flavor);
        if (index == n) {
            return;
        }
        DFS(index + 1, calorie + cal[index], flavor + score[index]);
        DFS(index + 1, calorie, flavor);
    }

}
