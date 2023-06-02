package Hash;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
// O(n+m)
public class _04_02 {
    public String solution(String a, String b) {
        String answer = "YES";
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char x : a.toCharArray()) {
            map1.put(x, map1.getOrDefault(x, 0) + 1);
        }
        for (char x : b.toCharArray()) {
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }
        for (char key : map1.keySet()) {
            if (!Objects.equals(map1.get(key), map2.get(key))) {
                answer = "NO";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        _04_02 T = new _04_02();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(T.solution(a, b));

    }
}
