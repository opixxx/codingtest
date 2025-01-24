package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1327 {
    static String init = "";
    static String result = "";
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            init += arr[i];
        }

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            result += num;
        }

        System.out.print(bfs());

    }

    static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        set.add(init);
        q.offer(new Pair(init, 0));

        while (!q.isEmpty()) {
            var cur = q.poll();
            String curStr = cur.str;
            int curCnt = cur.count;

            if (curStr.equals(result)) {
                return curCnt;
            }

            for (int i = 0; i <= n - k; i++) {
                char[] c = curStr.toCharArray();

                for (int j = 0; j < k / 2; j++) {
                    char tmp = c[i + j];
                    c[i + j] = c[i + k - 1 - j];
                    c[i + k - 1 - j] = tmp;
                }

                StringBuilder sb = new StringBuilder();
                for (char e : c) {
                    sb.append(e);
                }
                String reverse = sb.toString();

                if (!set.contains(reverse)) {
                    set.add(reverse);
                    q.offer(new Pair(reverse, curCnt + 1));
                }

            }
        }
        return -1;
    }

    static class Pair {
        String str;
        int count;

        public Pair(String str, int count) {
            this.str = str;
            this.count = count;
        }
    }
}
