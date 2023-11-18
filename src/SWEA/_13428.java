package SWEA;

import java.util.Scanner;

public class _13428 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for (int tc = 0; tc < test; tc++) {
            String num = sc.next();
            char[] n = num.toCharArray();

            int min = Integer.parseInt(num);
            int max = min;
            for (int i = 0; i < n.length; i++) {
                for (int j = i + 1; j < n.length; j++) {
                    char tmp = n[i];
                    n[i] = n[j];
                    n[j] = tmp;
                    if (n[0] != '0' && max < Integer.parseInt(String.valueOf(n))) {
                        max = Integer.parseInt(String.valueOf(n));
                    }
                    if (n[0] != '0' && min > Integer.parseInt(String.valueOf(n))) {
                        min = Integer.parseInt(String.valueOf(n));
                    }
                    tmp = n[i];
                    n[i] = n[j];
                    n[j] = tmp;

                }
            }
            System.out.println("#" + (tc + 1) + " " + min + " " + max);
        }
    }
}
