package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12970 {
    static int ACnt = 0, BCnt, n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        ACnt = getCharCnt();
        BCnt = n - ACnt;
        String[] answer = new String[n];

        if (ACnt != -1 && k != 0) {
            for (int i = 0; i < n; i++) {
                answer[i] = "B";
            }
            for (int i = 0; i < ACnt - 1; i++) {
                answer[i] = "A";
            }

            int a = (ACnt - 1) * BCnt;
            int b = k - a;

            answer[n - 1 - b] = "A";
        } else if (k == 0) {
            for (int i = 0; i < n; i++) {
                answer[i] = "B";
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str : answer) {
            sb.append(str);
        }
        System.out.println(ACnt == -1 ? -1 : sb);
    }

    static int getCharCnt() {

        ACnt = 1;
        BCnt = n - 1;
        while (ACnt * BCnt < k) {

            if (BCnt < 0) {
                return -1;
            }
            ACnt++;
            BCnt--;
        }
        return ACnt;
    }
}
