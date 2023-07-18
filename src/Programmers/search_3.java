package Programmers;
import java.util.*;

class Solution {
    HashSet<Integer> hset = new HashSet<>();
    public void recursive(String comb, String others) {
        if (!comb.equals("")) hset.add(Integer.valueOf(comb));

        for(int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i) , others.substring(0,i) + others.substring(i+1));
        }
    }
    public boolean isPrime(int number) {
        if(number == 0 || number == 1) return false;

        int lim = (int) Math.sqrt(number);
        for(int i = 2; i <= lim;  i++) {
            if(number % i == 0) return false;
        }
        return true;
    }

    public int solution(String numbers) {
        int answer = 0;
        recursive("",numbers);
        for (int number : hset) {
            if (isPrime(number)) {
                answer++;
            }
        }
        return answer;
    }
}