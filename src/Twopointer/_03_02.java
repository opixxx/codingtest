package Twopointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
// 시간복잡도 O(nm)
public class _03_02 {
    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        // int p1 = 0, p2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i] == b[j]) {
                    answer.add(b[j]);
                    break;
                }

            }
        }
        Collections.sort(answer);

        return answer;
    }
    public static void main(String[] args) {
        _03_02 T = new _03_02();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        for (int x : T.solution(n, m, a, b)) System.out.print(x + " ");
    }
}
