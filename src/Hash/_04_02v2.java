package Hash;

import java.util.HashMap;
import java.util.Scanner;
// O(n)
public class _04_02v2 {
    public String solution(String a, String b) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : a.toCharArray()) map.put(x, map.getOrDefault(x, 0) + 1);
        for (char x : b.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0)
                return "NO";
            map.put(x, map.get(x) - 1);

        }
        return answer;
    }
    public static void main(String[] args) {
        _04_02v2 T = new _04_02v2();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(T.solution(a, b));


    }


}
