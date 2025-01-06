package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1074v2 {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        count = 0;
        int size = (int) Math.pow(2, N);
        recursive(size, r, c);
        System.out.print(count);
    }

    static void recursive(int size, int r, int c) {
        int curSize = size / 2;

        if (size == 1) {
            return;
        }

        if (r < curSize && c < curSize) { //2사분면
            recursive(curSize, r, c );
        }
        else if (r < curSize && c >= curSize) { //1사분면
            count += curSize * curSize;
            recursive(curSize, r, c - curSize);
        }
        else if (r >= curSize && c < curSize) {//3사분면
            count += curSize * curSize * 2;
            recursive(curSize, r - curSize, c);
        }
        else {//4사분면
            count += curSize * curSize * 3;
            recursive(curSize, r - curSize, c - curSize);
        }


    }
}
