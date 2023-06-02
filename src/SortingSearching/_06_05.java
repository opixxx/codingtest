package SortingSearching;

import java.util.Arrays;
import java.util.Scanner;

public class _06_05 {
    public String solution(int n, int[] arr) {
        String answer = "U";
        int tmp;
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            tmp = arr[i];
            if (tmp == arr[i+1]) return "D";
        }
        return answer;


    }
    public static void main(String[] args) {
        _06_05 T = new _06_05();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
