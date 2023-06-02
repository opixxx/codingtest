package Twopointer;

import java.util.Scanner;

public class _03_06 {
    public int solution(int n, int k, int[] a) {
        int answer = 0, cnt = 0, lt =0;
        for (int rt = 0; rt < n; rt++) {
            if (a[rt] == 0) cnt++;
            while (cnt > k) {
                if (a[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);

        }
        return answer;

    }
    public static void main(String[] args) {
        _03_06 T = new _03_06();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, k, a));

    }
}
