package Baekjoon;

import java.util.Scanner;

public class _1213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        int[] count = new int[26];
        for (char ch : input.toCharArray()) {
            count[ch - 'A']++;
        }

        int oddCount = 0;
        int oddIndex = 0;

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                oddIndex = i;
            }
        }
        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            StringBuilder front = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < count[i] / 2; j++) {
                    front.append((char) (i + 'A'));
                }
            }

            StringBuilder back = new StringBuilder(front).reverse();
            if (oddCount == 1) {
                front.append((char) (oddIndex + 'A'));
            }
            front.append(back);
            System.out.println(front);

        }
    }
}

