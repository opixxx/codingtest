package Programmers;

import java.util.*;
class hash_4 {
    public int solution(String[][] clothes) {
        int answer = 0;
        int a = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        if(map.size() == 1){
            answer = clothes.length;
        } else {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                arr.add(entry.getValue());
            }
            for (int i = 0; i < arr.size(); i++) {
                a *= arr.get(i) + 1;
            }
            answer = a - 1;
        }
        return answer;
    }
}