package Programmers;

public class stackqueue_5 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int cnt = 0;
        for(int i = 0; i < prices.length; i++) {
            cnt = 0;
            for(int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    cnt++;
                } else {
                    cnt++;
                    answer[i] = cnt;
                    break;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}