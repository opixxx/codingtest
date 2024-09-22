package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15666 {
    static int n, m;
    static int[] arr;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        answer = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, 0);




    }

    private static void dfs(int start, int level) {
        if (level == m) {
            for (int val : answer) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        int lastUsed = -1;
        for (int i = start; i < n; i++) {
            if (arr[i] != lastUsed) {
                lastUsed = arr[i];
                answer[level] = arr[i];
                dfs(i, level + 1);
            }
        }

    }
}
