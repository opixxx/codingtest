package Programmers;

import java.util.*;
class sort_1 {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            int[] tmp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            int k = commands[i][2];
            Arrays.sort(tmp);

            answer[i] = tmp[k - 1];
        }
        return answer;
    }
}