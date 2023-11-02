package SWEA;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _1983 {
    static String[] result = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int percent = n / 10;

            double tmp = 0.0;

            Double[] totalScore = new Double[n];

            for (int i = 0; i < n; i++) {

                int midScore = sc.nextInt();
                int finalScore = sc.nextInt();
                int subScore = sc.nextInt();
                double sum = 0.35 * midScore + 0.45 * finalScore + 0.2 * subScore;
                totalScore[i] = sum;
                if (i + 1 == k) tmp = sum;

            }

            Arrays.sort(totalScore, Collections.reverseOrder());
            int rank = 0;
            for (int i = 0; i < totalScore.length; i++) {
                if (tmp == totalScore[i]) {
                    rank = i;
                }
            }
            rank = rank / percent;
            System.out.println("#" + t + " " +result[rank]);

        }

    }

}