package Baekjoon;
import java.io.*;
import java.util.*;
public class _2492 {
    static List<Pair> list;
    static int N, M, T, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Pair(a, b));
        }

        int max = Integer.MIN_VALUE;
        int[] answer = new int[2];
        for(int i = 0; i < T; i++) {
            for (int j = 0; j < T; j++) {
                int xx, yy;
                xx = Math.min(list.get(i).x, N - K);
                yy = Math.min(list.get(j).y, M - K);

                int curCnt = getCount(xx, yy);
                if (max < curCnt) {
                    max = curCnt;
                    answer[0] = xx;
                    answer[1] = yy + K;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer[0] + " " + answer[1]).append("\n").append(max);
        System.out.println(sb);
    }

    static int getCount(int x, int y) {
        int count = 0;
        for (Pair pair2 : list) {
            if (pair2.x >= x && pair2.x <= x + K && pair2.y >= y && pair2.y <= y + K) {
                count++;
            }
        }
        return count;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
