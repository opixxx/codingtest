package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        String s = st.nextToken();
        char[] c = s.toCharArray();

        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long x = 0;
        long y = 0;


        int n = d;
        for (int i = 0; i < d; i++) {
            n--;
            long size = (long) Math.pow(2, n);

            if (c[i] == '1') {
                y += size;
            } else if (c[i] == '3') {
                x += size;
            } else if (c[i] == '4') {
                x += size;
                y += size;
            }
        }
        x -= b;
        y += a;
        String result = "";

        for (int i = 0; i < d; i++) {
            long limit = (long) Math.pow(2, d - i);
            long half = (long) Math.pow(2, d - i - 1);

            if (x >= 0 && x < half && y >= 0 && y < half) {
                result += "2";
            } else if (x >= 0 && x < half && y >= half && y < limit) {
                y -= half;
                result += "1";
            } else if (x >= half && x < limit && y >= 0 && y < half) {
                x -= half;
                result += "3";
            } else if (x >= half && x < limit && y >= half && y < limit) {
                x -= half;
                y -= half;
                result += "4";
            }
        }

        System.out.println(result.length() == d ? result : -1);
    }
}
