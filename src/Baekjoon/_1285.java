package Baekjoon;

import java.util.Scanner;

public class _1285 {
    static char[][] map;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = sc.next().toCharArray();
        }

        int answer = Integer.MAX_VALUE;

        for (int bit = 0; bit < (1 << n); bit++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int back = 0;
                for (int j = 0; j < n; j++) {
                    char cur = map[j][i];

                    if ((bit & (1 << j)) != 0) {
                        cur = reverse(j, i);
                    }
                    if (cur == 'T') {
                        back++;
                    }
                }
                sum += Math.min(back, n - back);
            }
            answer = Math.min(answer, sum);

        }
        System.out.println(answer);
    }

    private static char reverse(int i, int j) {
        if (map[i][j] == 'T') {
            return 'H';
        } else {
            return 'T';
        }
    }
}
