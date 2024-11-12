package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1174 {
    static int[] numArr;
    static List<Long> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        numArr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        answer = new ArrayList<>();

        dfs(0L, 0);

        Collections.sort(answer);
        System.out.println(n > answer.size() ? "-1" : answer.get(n-1));


    }

    private static void dfs(long num, int level) {
        if (!answer.contains(num)) {
            answer.add(num);
        }

        if (level >= 10) {
            return;
        }

        dfs((num * 10) + numArr[level], level + 1);
        dfs(num, level + 1);
    }
}
