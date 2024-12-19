package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        Speech[] arr = new Speech[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            arr[i] = new Speech(p, d);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.p != b.p) {
                return b.p - a.p;
            } else {
                return b.d - a.d;
            }
        });

        boolean[] ch = new boolean[10001];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int day = arr[i].d;
            int pay = arr[i].p;

            for (int j = day; j >= 1; j--) {
                if (!ch[j]) {
                    ch[j] = true;
                    answer += pay;
                    break;
                }
            }
        }
        System.out.println(answer);








    }

    static class Speech {
        public int p;
        public int d;

        public Speech(int p, int d) {
            this.p = p;
            this.d = d;
        }
    }
}
