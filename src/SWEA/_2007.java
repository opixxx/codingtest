package SWEA;

import java.util.Scanner;

public class _2007 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i = 1; i <= n; i++) {
            String str = s.next();
            for (int j = 1; j <= 10; j++) {
                if (str.substring(0, j).equals(str.substring(j, j * 2))) {
                    System.out.println("#" + i + " " + j);
                    break;
                }
            }
        }
    }
}
