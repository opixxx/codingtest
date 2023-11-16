package SWEA;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _7272 {
    static List<Character> one = Arrays.asList('A', 'D', 'O', 'P', 'Q', 'R');
    static List<Character> none = Arrays.asList('C', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z');

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            String answer = "DIFF";
            String case1 = sc.next();
            String case2 = sc.next();
            String tmp1 = "";
            String tmp2 = "";
            if (case1.length() != case2.length()) {
                answer = "DIFF";
                System.out.println("#" + tc + " " + answer);
            } else {
                for (int i = 0; i < case1.length(); i++) {
                    if (one.contains(case1.charAt(i))) {
                        tmp1 += "A";
                    }
                    if (none.contains(case1.charAt(i))) {
                        tmp1 += "C";
                    }
                    if (case1.charAt(i) == 'B') {
                        tmp1 += "B";
                    }
                    if (one.contains(case2.charAt(i))) {
                        tmp2 += "A";
                    }
                    if (none.contains(case2.charAt(i))) {
                        tmp2 += "C";
                    }
                    if (case2.charAt(i) == 'B') {
                        tmp2 += "B";
                    }
                }
                if (tmp1.equals(tmp2)) {
                    answer = "SAME";
                }
                System.out.println("#" + tc + " " + answer);
            }
        }
    }
}
