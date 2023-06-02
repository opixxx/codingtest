package Array;

import java.util.Arrays;
import java.util.Scanner;

public class _02_04 {
    public int[] Solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i < n; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }

        return answer;
    }
    public static void main(String[] args) {
        _02_04 T = new _02_04();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int x : T.Solution(n)) {
            System.out.print(x + " ");
        }
    }
}
