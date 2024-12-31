package Programmers;

import java.util.HashSet;

public class 영어_끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int len = words.length;
        HashSet<String> set = new HashSet<>();

        set.add(words[0]);

        for (int i = 1; i < len; i++) {
            String word1 = words[i-1];
            String word2 = words[i];
            char lastC1 = word1.charAt(word1.length() - 1);
            char firstC2 = word2.charAt(0);
            if (lastC1 != firstC2 || set.contains(word2)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;

                return answer;

            }
            set.add(word2);
        }
        return answer;
    }
}
