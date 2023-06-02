package String;

import java.util.Scanner;

public class _01_02 {
    public String Solution(String str) {
        String answer = "";
        for (int i = 0; i < str.length(); i++) { // String 에 length 까지 반복
            char x = str.charAt(i); // chatAt()는 String 를 char 타입으로 바꿔준다. 왜냐 isupperCase, isLowerCase 를 사용하려고
            if (Character.isUpperCase(x)) { // Character.isUpperCase(x) -> x 문자가 대문자이면
                answer += Character.toLowerCase(x); // x 문자를 소문자로 바꾸고 answer 에다 누적해서 붙힌다
            } else {
                answer += Character.toUpperCase(x); // x 문자를 대문자로 바꾸고 answer 에다 누적해서 붙힌다
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        _01_02 T = new _01_02();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.Solution(str));
    }
}
