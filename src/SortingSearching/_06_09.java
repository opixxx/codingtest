package SortingSearching;

import java.util.Arrays;
import java.util.Scanner;

public class _06_09 {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int start = 0;
        int end = n - 1; // 7
        while (true) {
            int mid = (start + end) / 2;
            if (arr[mid] == m) {
                answer = mid + 1;
                break;
            }
            if (arr[mid] > m) end = mid - 1;
            else start = mid + 1;
        }
        return answer;

    }
    public static void main(String[] args) {
        _06_09 T = new _06_09();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }
}
