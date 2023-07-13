package Programmers;
import java.util.*;
class hash_3 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();
        for(String x : phone_book) set.add(x);
        for (String x : phone_book) {
            for (int i = 1; i <x.length(); i++) {
                if(set.contains(x.substring(0, i))) return false;
            }
        }
        return answer;
    }
}