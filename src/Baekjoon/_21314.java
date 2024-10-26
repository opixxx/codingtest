package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 글자를 나눌 수 있는 경우의 수를 구해서 값을 다 구하려고 했는데 글자수 3000개라 시간이 안될 것 같았음
 * 숫자가 최대값으로 나오는 경우와 최소값으로 나오는 경우를 생각해서 계산
 */
public class _21314 {
    static String input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        System.out.println(maxNum(false));
        System.out.println(minNum(false));

    }

    // M 이 나왔을 때 K가 나올때까지 보다가 K가 나오면 K전까지만 변경
    // K 나오면 바로 5로
    private static String minNum(boolean flag) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!flag && c == 'K') sb.append(5);
            if (c == 'M') {
                flag = true;
                count++;
            } else if (flag && c == 'K') {
                sb.append(1).append("0".repeat(count - 1)).append(5);
                flag = false;
                count = 0;
            }
        }
        if (count != 0) {
            sb.append(1).append("0".repeat(count - 1));
        }
        return sb.toString();
    }

    // M이 연속되다가 K 만나면 그게 최댓값
    private static String maxNum(boolean flag) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!flag && c == 'K') sb.append(5);
            if (c == 'M') {
                count++;
                flag = true;
            } else if (flag && c == 'K') {
                sb.append(5).append("0".repeat(count));
                flag = false;
                count = 0;
            }
        }
        if (count != 0) {
            sb.append("1".repeat(count));
        }
        return sb.toString();
    }
}
