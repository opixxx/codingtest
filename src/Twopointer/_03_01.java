package Twopointer;

import java.util.Arrays;
import java.util.Scanner;

public class _03_01 {
    public int[] solution(int n, int m, int[] arr1, int[] arr2) {
        int[] answer;
        int[] tmp = Arrays.copyOf(arr1, arr1.length + arr2.length);
        System.arraycopy(arr2, 0, tmp, arr1.length, arr2.length);
        Arrays.sort(tmp);
        answer = tmp;



        return answer;
    }
    public static void main(String[] args) {
        _03_01 T = new _03_01();
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        for (int x : T.solution(n, m, arr1, arr2)) System.out.print(x + " ");


    }
}
