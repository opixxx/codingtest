package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1107 {
    static boolean[] button;
    static int n;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        button = new boolean[10];

        Arrays.fill(button, true);

        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < m; i++) {
                int errorButton = Integer.parseInt(st.nextToken());
                button[errorButton] = false;
            }
        }

        if (n == 100) {
            System.out.println(0);
            return;
        }
        answer = Math.min(answer, Math.abs(n - 100));

        bruteForce(0, 0);
        System.out.println(answer);
    }

    private static void bruteForce(int level, int channel) {

        for (int i = 0; i <= 9; i++) {
            if (button[i]) {
                int newChannel = channel * 10 + i;
                int result = Math.abs(newChannel - n) + String.valueOf(newChannel).length();
                answer = Math.min(answer, result);
                if (level < 6) {
                    bruteForce(level + 1, newChannel);
                }
            }
        }
    }
}
