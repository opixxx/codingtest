package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _6443 {
    static char[] arr;
    static boolean[] ch;
    static char[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            arr = br.readLine().toCharArray();
            ch = new boolean[arr.length];
            answer = new char[arr.length];

            Arrays.sort(arr);

            dfs(0);
        }
        System.out.println(sb);
    }

    private static void dfs(int level) {
        if (level == answer.length) {
            sb.append(answer).append("\n");
            return;
        }
        int lastUser = -1;
        for (int i = 0; i < arr.length; i++) {
            if (!ch[i] && arr[i] != lastUser) {
                answer[level] = arr[i];
                ch[i] = true;
                lastUser = arr[i];
                dfs(level + 1);
                ch[i] = false;
            }
        }
    }
}
