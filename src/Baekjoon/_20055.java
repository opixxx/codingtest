package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] belt = new int[N * 2];

        boolean[] robot = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int level = 0;
        while (true) {
            level++;

            int tmp = belt[N * 2 - 1];
            for (int i = N * 2 - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = tmp;

            for (int i = N - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }

            robot[0] = false;
            robot[N - 1] = false;

            for (int i = N - 1; i > 0; i--) {
                if (robot[i - 1] && !robot[i] && belt[i] > 0) {
                    robot[i - 1] = false;
                    robot[i] = true;
                    belt[i]--;
                    robot[N - 1] = false;
                }
            }

            if (belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
            }

            int count = 0;
            for (int i = 0; i < N * 2; i++) {
                if (belt[i] == 0) {
                    count++;
                }
            }
            if (count >= K) {
                break;
            }

        }
        System.out.print(level);
    }
}
