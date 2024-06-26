package Baekjoon.dfs_bfs;

import java.util.Arrays;
import java.util.Scanner;

public class _1759v2 {
    static int l,c;
    static char[] aeiou = {'a', 'e', 'i', 'o', 'u'};
    static char[] str;
    static char[] pwd;
    static int[] ch;
    public void combi(int C, int L) {
        if(C == l) {
            if(Check(pwd)) {
                for(char result : pwd) {
                    System.out.print(result);
                }
                System.out.println();
            }
        }
        else {
            for (int i = L; i < c ; i++) {
                pwd[C] = str[i];
                combi(C + 1, i + 1);

            }
        }
    }
    public static boolean Check(char[] pwd) {
        int aeiou_cnt = 0;
        for (char s : pwd) {
            for (int j = 0; j < 5; j++) {
                if (s == aeiou[j]) aeiou_cnt++;
            }
        }
        return aeiou_cnt >= 1 && l - aeiou_cnt >= 2;
    }

    public static void main(String[] args) {

        _1759v2 T = new _1759v2();
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();
        ch = new int[l];
        str = new char[c];
        pwd = new char[l]; // 결과값 저장 하는 곳
        for (int i = 0; i < c; i++) {
            str[i] = sc.next().charAt(0);
        }
        Arrays.sort(str);
        T.combi(0,0);
    }
}
