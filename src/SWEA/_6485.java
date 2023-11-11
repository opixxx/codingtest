package SWEA;

import java.util.Scanner;

public class _6485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            int[] answer = new int[5001];
            int n = sc.nextInt(); // 버스 노선
            for (int i = 0; i < n; i++) {
                int A = sc.nextInt();
                int B = sc.nextInt();
                for (int j = A; j <= B; j++) {
                    answer[j]++;
                }
            }
            int p = sc.nextInt();
            int[] result = new int[p];
            for (int i = 0; i < p; i++) {
                int c = sc.nextInt();
                result[i] = answer[c];
            }
            System.out.print("#" + tc + " ");
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
    }
}
