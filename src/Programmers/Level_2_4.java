package Programmers;

class Level_2_4 {
    public int solution(int n) {
        int answer = 0;
        int cnt = 0;
        String a = Integer.toBinaryString(n);
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == '1') cnt++;
        }
        while(true) {
            int count = 0;
            n++;
            String tmp = Integer.toBinaryString(n);
            for(int i = 0; i < tmp.length(); i++) {
                if(tmp.charAt(i) == '1') count++;
            }
            if(cnt == count) {
                answer = n;
                break;
            }
            // Integer.bitCount() 사용하면 더 간결한 코드 가능


        }
        return answer;
    }
}