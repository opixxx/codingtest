package Programmers;

import java.util.*;
class hash_4 {
    public int solution(String[][] clothes) {
        int answer;
        int a = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            arr.add(entry.getValue());
        }
        for (int x : arr) {
            a *= x + 1;
        }
        answer = a - 1;

        return answer;
    }
}