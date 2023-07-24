package Baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class _1759 {
    static char[] aeiou = {'a', 'e', 'i', 'o', 'u'};
    static int l, c;
    static ArrayList<String> list = new ArrayList<>();
    static HashSet<String> set = new HashSet<>();
    static int aeiou_cnt = 0;
    static int[] ch;
    static String[] str;
    public void DFS(String s, int L) {
        if(L == l) {
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < 5; j++) {
                    if(s.charAt(i) ==  aeiou[j]) {
                        aeiou_cnt++;
                    }
                }
            }
            if (aeiou_cnt >= 1 && c - aeiou_cnt >= 2) {

                list.add(s);

            }
            aeiou_cnt = 0;
        }
        else {
            for (int i = 0; i < c; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    DFS(s + str[i], L + 1);
                    ch[i] = 0;
                }
            }

        }

    }
    public static void main(String[] args) {
        _1759 T = new _1759();
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();
        ch = new int[c];
        str = new String[c];
        for (int i = 0; i < c; i++) {
            str[i] = sc.next();
        }
        Arrays.sort(str);
        T.DFS("", 0);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
