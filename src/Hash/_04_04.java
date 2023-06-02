package Hash;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class _04_04 {
    public int solution(String s, String t) {
        int answer = 0;
        HashMap<Character, Integer> hm1 = new HashMap<>(); // t
        HashMap<Character, Integer> hm2 = new HashMap<>(); // s
        for (char x : t.toCharArray()) hm1.put(x, hm1.getOrDefault(x, 0) + 1); // t 에 맵
        int r = t.length() - 1; // 2
        for (int i = 0; i < r; i++) hm2.put(s.charAt(i), hm2.getOrDefault(s.charAt(i), 0 ) + 1);
        int lt = 0;
        for (int rt = r; rt < s.length(); rt++) { // t.length() -> 3 s.length() -> 9
            hm2.put(s.charAt(rt), hm2.getOrDefault(s.charAt(rt), 0 ) + 1);
            if (hm1.equals(hm2)) answer++;
            hm2.put(s.charAt(lt), hm2.get(s.charAt(lt)) - 1);
            if (hm2.get(s.charAt(lt)) == 0) hm2.remove(s.charAt(lt));
            lt++;
        }
        return answer;
    }
    public static void main(String[] args) {
        _04_04 T = new _04_04();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(T.solution(s, t));



    }

}
