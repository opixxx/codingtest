package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
* bfs 로 몸통 비틀기 시도했으나 메모리 초과,,,
* */
public class _1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int dis = y - x;

            int a = (int) Math.sqrt(dis);

            if (a == Math.sqrt(dis)) {
                System.out.println(a * 2 - 1);
            } else if (dis <= a * a + a) {
                System.out.println(a * 2);
            } else {
                System.out.println(a * 2 + 1);
            }
        }
    }
}
