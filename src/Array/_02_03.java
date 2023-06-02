package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class _02_03 {
    public String Solution(int n, int[] A, int[] B) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (A[i] == B[i])  answer.append("D");
            else if (A[i] == 1 && B[i] == 3)  answer.append("A");
            else if (A[i] == 2 && B[i] == 1)  answer.append("A");
            else if (A[i] == 3 && B[i] == 2)  answer.append("A");
            else  answer.append("B");
        }
        return answer.toString();
    }



    public static void main(String[] args) {
        _02_03 T = new _02_03();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        for (char c : T.Solution(n, A, B).toCharArray()) System.out.println(c);
    }
}
