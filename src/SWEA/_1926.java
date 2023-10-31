package SWEA;

import java.util.Scanner;

public class _1926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
           String tmp = String.valueOf(i);
           if (tmp.contains("3") || tmp.contains("6") || tmp.contains("9")) {
               tmp = tmp.replace("3", "-");
               tmp = tmp.replace("6", "-");
               tmp = tmp.replace("9", "-");

               tmp = tmp.replace("0", "-");
               tmp = tmp.replace("1", "");
               tmp = tmp.replace("2", "");
               tmp = tmp.replace("4", "");
               tmp = tmp.replace("5", "");
               tmp = tmp.replace("7", "");
               tmp = tmp.replace("8", "");
           }
           System.out.print(tmp + " ");
        }
    }
}