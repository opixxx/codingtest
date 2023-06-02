package String;

import java.util.Scanner;

public class _01_12 {
    public String Solution(int n, String s) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2); //tmp 를 10진수로 바꾼다
            char c = (char)num; // 십진수인 num 을 문자로 변환 아스키코드르를 이용해서
            answer += c;
            s = s.substring(7);
        }
        return answer;
    }

    public static void main(String[] args) {
        _01_12 T = new _01_12();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(T.Solution(n, str));

    }
}
