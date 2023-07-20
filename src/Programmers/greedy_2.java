package Programmers;


class greedy_2 {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1; // 조이스틱 좌우의 최대값
        int[] cnt = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1}; // A~Z 상,하 스틱 이동 수

        // 상,하 조이스틱 총 움직임 수
        for(int c : name.toCharArray()) {
            answer += cnt[c - 'A'];
        }

        for(int i = 0; i < len; i++) {
            int next = i + 1;
            while(next < len && name.charAt(next) == 'A') {
                next++;
            }
            move = Math.min(move, i + len - next + Math.min(i, len - next));
        }
        return answer + move;
    }
}
