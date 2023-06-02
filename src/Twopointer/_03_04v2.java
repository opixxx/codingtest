package Twopointer;

import java.util.Scanner;

public class _03_04v2 {
    public int solution(int n, int m, int[] a) {
        int answer = 0, lt = 0, sum = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += a[rt];
            if (sum == m) answer++;
            while (sum >= m) {
                sum -= a[lt++];
                if (sum == m) answer++;

            }
        }
        return answer;
    }
    public static void main(String[] args) {
        _03_04 T = new _03_04();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, m, a));
    }
}
