package Programmers;
import java.util.*;
class WordDepth {
    String str;
    int dept;
    WordDepth(String str, int dept) {
        this.str = str;
        this.dept = dept;
    }
}

class DFSBFS_4v2 {
    static int[] ch;
    static int answer = 0;
    public void BFS(String begin, int depth, String[] words, String target) {

        Queue<WordDepth> q = new LinkedList<>();
        q.offer(new WordDepth(begin, depth));

        while(!q.isEmpty()) {
            WordDepth tmp = q.poll();
            String current = tmp.str;
            int currentDept = tmp.dept;
            if(current.equals(target)) {
                answer = currentDept;
                return;
            }
            for(int i = 0; i < words.length; i++) {
                if(ch[i] == 0 && possibleChange(current, words[i]) == 1) {
                    ch[i] = 1;
                    q.offer(new WordDepth(words[i], currentDept + 1));
                }
            }
        }
    }
    public int possibleChange(String a, String b) {
        int cnt = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == b.charAt(i)) {
                cnt++;
            }
            if(cnt == a.length() - 1) return 1;
        }
        return 0;
    }

    public int solution(String begin, String target, String[] words) {
        ch = new int[words.length];
        BFS(begin, 0, words, target);
        return answer;
    }
}