package Programmers;

class greedy_1 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] st = new int[n + 2];
        for(int l : lost) {
            st[l]--;
        }
        for(int r : reserve) {
            st[r]++;
        }

        for(int i = 1; i <= n; i++) {
            if (st[i] == 1) {
                if (st[i - 1] == -1) {
                    st[i]--;
                    st[i - 1]++;
                } else if (st[i + 1] == -1) {
                    st[i]--;
                    st[i + 1]++;
                }
            }
        }
        for(int i = 1; i <= n; i++) {
            if(st[i] >= 0) answer++;
        }
        return answer;
    }
}
