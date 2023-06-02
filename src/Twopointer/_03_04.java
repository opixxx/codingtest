package Twopointer;

import java.util.Scanner;

public class _03_04 {
    public int solution(int n, int m, int[] a) {
        int answer = 0;
        int p1 = 0, p2 = 0;
        int sum = a[0];
        int cnt = 0;
        int cnt1 = 0;
        while (p2 < n - 1) {
            if (sum == m) {
                cnt++;
                p1++;
                p2 = p1;
                if (p1 < n) {
                    sum = a[p1];
                }
            } else if (sum < m) {
                p2++;
                if (p2 < n) {
                    sum += a[p2];
                }
            } else {
                sum -= a[p1];
                p1++;
                if (p1 > p2 && p1 < n) {
                    p2 = p1;
                    sum = a[p1];
                }
            }
        }
        if (sum == m) cnt++;
        answer = cnt;
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
