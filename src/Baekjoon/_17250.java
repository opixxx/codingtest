package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _17250 {
    static int[] a = new int[100001];
    static int[] unf = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 처리 및 초기화
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(br.readLine());
            unf[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(union(x, y)).append('\n');
        }

        System.out.print(sb);
    }

    static int find(int x) {
        if (unf[x] == x) return x;
        return unf[x] = find(unf[x]);
    }

    static int union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px != py) {
            if (x < y) {
                unf[py] = px;
                a[px] += a[py];
                return a[px];
            } else {
                unf[px] = py;
                a[py] += a[px];
                return a[py];
            }
        } else {
            return a[px];
        }
    }
}
