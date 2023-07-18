package Programmers;
import java.util.*;
class search_7 {
    static String[] aeiou;
    static ArrayList<String> list;

    public void DFS(String s, int L, String word) {
        list.add(s);

        if (L == 5) return;
        for (int i = 0; i < 5; i++) {
            DFS(s + aeiou[i], L + 1, word);
        }
    }

    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        aeiou = new String[]{"A", "E", "I", "O", "U"};
        DFS("", 0, word);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}