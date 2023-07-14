package Programmers;

import java.util.*;
class stackqueue_4 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int x : truck_weights) {
            while(true) {
                if (q.isEmpty()) {
                    q.offer(x);
                    sum += x;
                    answer++;
                    break;
                }
                else if (q.size() == bridge_length) {
                    sum -= q.poll();
                }
                else {
                    if (sum + x <= weight) {
                        q.offer(x);
                        sum += x;
                        answer++;
                        break;
                    }
                    else {
                        q.offer(0);
                        answer++;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}