package Baekjoon;

import java.io.IOException;
import java.util.*;
import java.io.*;

public class _12924 {
    static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());


        int answer = 0;
        for (int i = A; i <= B; i++) {
            answer += getNum(i);
        }

        System.out.println(answer);
    }

    static int getNum(int num) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        String strNum = String.valueOf(num);
        int numLen = strNum.length();
        for (int j = 1; j < numLen; j++) {
            int newNum = Integer.parseInt(strNum.substring(j) + strNum.substring(0, j));
            if (newNum > num && newNum <= B && !set.contains(newNum)) {
                result++;
                set.add(newNum);
            }
        }
        return result;
    }
}
