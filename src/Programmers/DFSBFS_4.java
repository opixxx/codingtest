package Programmers;

class DFSBFS_4 {
    static int answer = Integer.MAX_VALUE;
    static int[] ch;
    public void DFS(int L, String begin, String target, String[] words) {
        if(L >= answer) return;
        if(begin.equals(target)) {
            answer = L;
        } else {
            for (int i = 0; i < words.length; i++) {
                int cnt = 0;
                for(int j = 0; j < begin.length(); j++) {
                    if(ch[i] == 0 && begin.charAt(j) == words[i].charAt(j)) {
                        cnt++;
                    }
                    if(cnt == begin.length() - 1) {
                        ch[i] = 1;
                        DFS(L + 1, words[i], target, words);
                        ch[i] = 0;
                    }
                }
            }
        }
    }
    public int solution(String begin, String target, String[] words) {

        ch = new int[words.length];
        DFS(0, begin, target, words);
        if(answer == Integer.MAX_VALUE) answer = 0;
        return answer;
    }
}