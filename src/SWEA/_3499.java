package SWEA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _3499 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            int n = sc.nextInt();

            List<String> list = new ArrayList<>();

            String[] arr = new String[n];
            int half = (arr.length + 1) / 2;

            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.next();
            }
            for (int i = 0; i < half; i++) {
                list.add(arr[i]);
                if (i + half < arr.length) {
                    list.add(arr[i + half]);
                }
            }

            System.out.print("#" + tc + " ");
            for (String a : list) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
