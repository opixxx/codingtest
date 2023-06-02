package Hash;

import java.util.HashMap;
import java.util.Scanner;

public class _04_01 {
    public char solution(int n, String s) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1); // getOrDefault -> x 라는 키값이 없으면 0 을 리턴
        } // HashMap key-value 설정
        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        //map.put(key, value); key-value 값 설정하는 함수
        //map.keySet(); HashMap에 저장된 키를 갖고 온다
        //map.getOrDefault(); 해당 하는 키 값이 없다면 default 값을 리턴
        //map.get(); 해당 key에 value 값을 리턴
        //map.remove(); 해당 key 값을 제거하고 value 값을 출력
        //map.size(); key 의 갯수를 출력
        //map.containsKey(); 해당 key 값에 존재를 true, false 출력
        return answer;
    }

    public static void main(String[] args) {
        _04_01 T = new _04_01();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(T.solution(n, str));
    }
}
