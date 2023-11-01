package SWEA;

import java.util.Scanner;

public class _1989 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t = 1; t <= test ; t++) {
            int result = 1;
            String str = sc.next();
            int len = str.length();
            for (int i = 0; i < len / 2; i++) {
                if (str.charAt(i) != str.charAt(len - i - 1)) {
                    result = 0;
                    break;
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }
}
