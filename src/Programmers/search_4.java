package Programmers;


class search_4 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int lim = (int) Math.sqrt(yellow);
        for(int i = 1; i<= lim; i++) {
            if(yellow % i == 0) {
                int len = yellow / i; // len -> 가로 i -> 높이
                if((len * 2) + (i * 2) + 4 == brown) {
                    answer[0] = len + 2;
                    answer[1] = i + 2;
                    break;
                }
            }
        }
        return answer;
    }
}

