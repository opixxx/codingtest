package Programmers;

import java.util.*;
class Heap_1 {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j : scoville) {
            pq.offer(j);
        }
        while(!pq.isEmpty()) {

            if (pq.peek() < K){
                int a = pq.poll();
                int b = pq.poll();
                int new_Scoville = a + (b * 2);
                pq.offer(new_Scoville);
                answer++;

            }
            if(pq.peek() >= K) break;
            if (pq.size() == 1) return -1;
        }
        return answer;
    }
}