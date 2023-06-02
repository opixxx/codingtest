package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _02_09 {
    public int solution(int n ,int[][] arr) {
        int answer = 0;
        int a = 0;
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a += arr[i][j];
            }
            tmp.add(a);
            a = 0;
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                a += arr[i][j];
            }
            tmp.add(a);
            a = 0;
        }
        for (int i = 0; i < n; i++) {
            a += arr[i][n - 1 - i];
        }
        tmp.add(a);
        a = 0;
        for (int i = 0; i < n; i++) {
            a += arr[i][i];
        }
        tmp.add(a);
        answer = Collections.max(tmp);
        return answer;
    }

    public static void main(String[] args) {
        _02_09 T = new _02_09();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));

    }
}
