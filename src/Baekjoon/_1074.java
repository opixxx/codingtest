package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1074 {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        recursive((int) Math.pow(2, n), r, c);

        System.out.println(count);
    }

    private static void recursive(int size, int r, int c) {

        if(size == 1)
            return;

        if(r < size/2 && c < size/2) { //2사분면
            recursive(size/2, r, c);
        }
        else if(r < size/2 && c >= size/2) {//1사분면
            count += size * size / 4;
            recursive(size/2, r, c - size/2);
        }
        else if(r >= size/2 && c < size/2) {//3사분면
            count += (size * size / 4) * 2;
            recursive(size/2, r - size/2, c);
        }
        else {//4사분면
            count += (size * size / 4) * 3;
            recursive(size/2, r - size/2, c - size/2);
        }
    }

}
