package SWEA;

import java.util.Scanner;

public class _1213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int test = sc.nextInt();
            String target = sc.next();
            String str = sc.next();
            int count = 0;
            int len = str.length() - target.length() + 1;
            for (int i = 0; i < len; i++) {
                if (target.equals(str.substring(i, i + target.length()))) {
                    count++;
                }
            }
            System.out.println("#" + test + " " + count);

        }


    }
}
