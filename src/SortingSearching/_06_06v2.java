package SortingSearching;

import java.util.HashSet;
import java.util.Scanner;

public class _06_06v2 {
    public String solution(int n, int[] arr) {
        String answer = "U";
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i])) {
                answer = "D";
                break;
            }
            set.add(arr[i]);
        }
        return answer;

    }
    public static void main(String[] args) {
        _06_06v2 T = new _06_06v2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, arr));

    }
}
