package Programmers;

import java.util.*;
class search_2 {
    public int[] solution(int[] answers) {
        int len = answers.length;
        int[] st_1 = {1,2,3,4,5};
        int[] st_2 = {2,1,2,3,2,4,2,5};
        int[] st_3 = {3,3,1,1,2,2,4,4,5,5};
        int[] score = {0,0,0};
        for(int i = 0; i < len; i++) {
            if (answers[i] == st_1[i % 5]) score[0]++;
            if (answers[i] == st_2[i % 8]) score[1]++;
            if (answers[i] == st_3[i % 10]) score[2]++;
        }
        int max = Math.max(score[0], Math.max(score[1], score[2]));

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if(score[i] == max) list.add(i + 1);
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}