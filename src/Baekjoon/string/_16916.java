package Baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _16916 {
    static int radix = 256;
    static int mod = 101;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String p = br.readLine();
        String s = br.readLine();

        int lenP = p.length();
        int lenS = s.length();

        long hash = getHash(s);

        for (int i = 0; i <= lenP - lenS; i++) {
            String tmp = p.substring(i, i + lenS);
            if (hash == getHash(tmp)) {
                if (check(s, tmp)) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }

    private static boolean check(String s, String tmp) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != tmp.charAt(i)) {
                return false;
            }
        }

        return true;
    }


    private static long getHash(String input) {
        long hash = 0;

        for (int i = 0; i < input.length(); i++) {
            hash = (radix * hash + input.charAt(i)) % mod;
        }
        return hash;
    }
}
