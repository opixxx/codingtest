package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17615 {
    static char[] input;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();

        int a = leftRed();
        int b = leftBlue();
        int c = rightRed();
        int d = rightBlue();

        int e = Math.min(a, b);
        int f = Math.min(c, d);

        System.out.print(Math.min(e, f));
    }

    private static int rightBlue() {
        boolean flag = false;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (input[i] == 'R') {
                flag = true;
            }
            if (input[i] == 'B' && flag) {
                count++;
            }
        }
        return count;
    }

    private static int rightRed() {
        boolean flag = false;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (input[i] == 'B') {
                flag = true;
            }
            if (input[i] == 'R' && flag) {
                count++;
            }
        }
        return count;
    }

    private static int leftRed() {
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (input[i] == 'B') {
                flag = true;
            }
            if (input[i] == 'R' && flag) {
                count++;
            }
        }
        return count;
    }
    private static int leftBlue() {
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (input[i] == 'R') {
                flag = true;
            }
            if (input[i] == 'B' && flag) {
                count++;
            }
        }
        return count;
    }
}
