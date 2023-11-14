package SWEA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _1221 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] num = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

        int test = sc.nextInt();

        for (int tc = 1; tc <= test; tc++) {
            String a = sc.next();
            int number = sc.nextInt();
            List<Integer> answer = new ArrayList<>();

            for (int i = 0; i < number; i++) {
                String tmp = sc.next();
                for (int j = 0; j < 10; j++) {
                    if (num[j].equals(tmp)) {
                        answer.add(j);
                    }
                }
            }
            Collections.sort(answer);
            System.out.println("#" + tc);
            for (int b : answer) {
                System.out.print(num[b] + " ");
            }
            System.out.println();

        }
    }
}
