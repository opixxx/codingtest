package SWEA;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _4406 {
    static List<String> list = Arrays.asList("a", "e", "i", "o", "u");
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 0; tc < test; tc++) {
            String answer = "";
            String str = sc.next();
            for (int i = 0; i < str.length(); i++) {
                String substring = str.substring(i, i + 1);
                if (!list.contains(substring)) {
                    answer += substring;
                }
            }
            System.out.println("#" + (tc + 1) + " " + answer);
        }
    }

}
