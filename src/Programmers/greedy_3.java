package Programmers;

import java.util.*;
class greedy_3 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length() - k;
        int index = 0;
        for (int i = 0; i < len; i++) {
            int max = 0;
            for(int j = index; j <= i + k; j++) {
                int current = number.charAt(j) - '0';
                if(max < current) {
                    max = current;
                    index = j + 1;
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }
}