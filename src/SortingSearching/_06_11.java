package SortingSearching;

import java.util.Arrays;
import java.util.Scanner;

public class _06_11 {
    public int count(int[] arr, int mid) {
        int cnt = 1;
        int ep = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - ep >= mid) {
                cnt++;
                ep = arr[i];
            }

        }
        return cnt;

    }
    public int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n - 1];
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) >= c) {
                lt = mid + 1;
                answer = mid;
            }else rt = mid - 1;
        }
        return answer;
    }



    public static void main(String[] args) {
        _06_11 T = new _06_11();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(T.solution(n, c, arr));
    }
}
