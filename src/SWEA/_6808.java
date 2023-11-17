package SWEA;

import java.util.Scanner;

public class _6808 {
    static int[] ch, result, B, A;
    static int count;
    public static void perm(int index) {
        if (index == 9) {
            int AScore = 0;
            int BScore = 0;

            for (int i = 0; i < 9; i++) {
                if (A[i] > result[i]) {
                    AScore += A[i] + result[i];
                } else {
                    BScore += A[i] + result[i];
                }
            }
            if (AScore > BScore) {
                count++;
                return;
            }

        }
        for (int i = 0; i < 9; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                result[index] = B[i];
                perm(index + 1);
                ch[i] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int tc = 1; tc <= test; tc++) {
            A = new int[9];
            B = new int[9];

            boolean[] card = new boolean[19];

            for (int i = 0; i < 9; i++) {
                A[i] = sc.nextInt();
                card[A[i]] = true;
            }

            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!card[i]) {
                    B[idx] = i;
                    idx++;
                }
            }
            ch = new int[9];
            result = new int[9];
            count = 0;
            perm(0);

            System.out.println("#" + tc + " " + count + " " + (362880 - count));

        }
    }
}
