package Twopointer;

import java.util.Arrays;
import java.util.Scanner;

public class _03_05 {
    public int solution(int n, int[] arr) {
        int answer = 0;
        int lt = 0, sum = 0;
        for (int rt = 0; rt < arr.length; rt++) {
            sum += arr[rt];
            if (sum == n) {
                answer++;
            }
            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        _03_05 T = new _03_05();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[(n / 2) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(T.solution(n, arr));

    }
}
