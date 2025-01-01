package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 귤_고르기 {
    static final int SIZE = 10_000_000;
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int a : tangerine) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();

        for (Integer value : map.values()) {
            list.add(value);
        }
        list.sort(Collections.reverseOrder());

        int tmp = 0;
        int idx = 0;
        while (true) {
            if (tmp >= k) {
                break;
            }

            tmp += list.get(idx);
            answer++;
            idx++;
        }
        return answer;

    }
}
