package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _2529 {
    static int n;
    static int[] ch;
    static char[] arr = new char[10];
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ch = new int[10];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().charAt(0);
        }

        DFS(0, "");

        Collections.sort(list);

        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));

    }

    private static void DFS(int idx, String num) {
        if (idx == n + 1) {
            list.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (ch[i] == 1) {
                continue;
            }
            if (idx == 0 || isBig(num.charAt(idx - 1) - '0', i, arr[idx - 1])) {
                ch[i] = 1;
                DFS(idx + 1, num + i);
                ch[i] = 0;
            }
        }

    }




    public static boolean isBig(int a, int b, char c) {
        if (c == '>') {

            if (a > b) {
                return true;
            }
        }
        if (c == '<') {
            if (a < b) {
                return true;
            }
        }
        return false;
    }

}
