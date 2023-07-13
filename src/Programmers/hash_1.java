package Programmers;

import java.util.*;
class hash_1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String x : participant) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x,1);
            }
        }
        for (String x : completion) {
            if(map.containsKey(x)) {
                map.put(x, map.get(x) - 1);
            }
        }
        for (String x : participant) {
            if (map.get(x) > 0) {
                answer = x;
                break;
            }
        }

        return answer;
    }
}