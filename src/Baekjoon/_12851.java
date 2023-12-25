package Baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _12851 {
    static int n, k, count;
    static int answer = Integer.MAX_VALUE / 16;
    static int[] ch = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (n >= k) {
            System.out.println(n - k);
            System.out.println(1);
            return;
        }

        BFS(n);
        System.out.println(answer);
        System.out.println(count);
    }

    private static void BFS(int n) {
        count = 0;

        Queue<Integer> q = new LinkedList<>();

        q.offer(n);
        ch[n] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (answer < ch[cur]) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 0) {
                    nx = cur + 1;
                } else if (i == 1) {
                    nx = cur - 1;
                } else {
                    nx = cur * 2;
                }

                if (nx == k) {
                    answer = ch[cur];
                    count++;
                }

                if (nx >= 0 && nx <= 100000 && (ch[nx] == 0 || ch[nx] == ch[cur] + 1)) {
                    q.offer(nx);
                    ch[nx] = ch[cur] + 1;
                }
            }
        }
    }
}
