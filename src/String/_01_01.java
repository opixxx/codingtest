package String;

import java.util.Scanner;

public class _01_01 {
    public int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase(); // 대소문자 구분안한다고 했으니 모두 대문자로 변환
        t = Character.toUpperCase(t); // 대소문자 구분안한다고 했으니 모두 대문자로 변환
        for (char x : str.toCharArray()) {
            if (x == t) answer++;
            /*for(int i=0; i<str.length(); i++){
			if(str.charAt(i)==t) answer++;
		}*/
        }
        return answer;
    }
    public static void main(String[] args) {
        _01_01 T = new _01_01();
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); // 문자열 받음
        char c = sc.next().charAt(0); // Scanner는 문자열만 받을 수 있음 char 타입을 받기위해서 charAt()을 사용
        System.out.print(T.solution(str, c));
    }
}
