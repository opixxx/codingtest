package Baekjoon;

import java.util.Scanner;

public class _2828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int start = 0, end = start + m -1;
        int j = sc.nextInt();
        int answer = 0;

        for (int i = 0; i < j; i++) {
            int apple = sc.nextInt() - 1;
            if (apple > end) {
                int tmp = apple - end;
                answer += tmp;
                start += tmp;
                end += tmp;
            } else if (apple < start) {
                int tmp = start - apple;
                answer += tmp;
                start -= tmp;
                end -= tmp;
            }

        }

        System.out.println(answer);

    }
}
