package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class _1289 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            int count = 0;
            String str = sc.next();
            char[] target = str.toCharArray();
            char[] tmp = str.replaceAll("1", "0").toCharArray();
            for (int i = 0; i < str.length(); i++) {
                if (Arrays.equals(target, tmp)) {
                    break;
                }
                if (target[i] != tmp[i]) {
                    char temp = target[i];
                    for (int j = i; j < tmp.length; j++) {
                        tmp[j] = temp;
                    }
                    count++;
                }
            }
            System.out.println("#" + tc + " " + count);
        }
    }
}
