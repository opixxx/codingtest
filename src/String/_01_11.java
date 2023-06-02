package String;

import java.util.Scanner;

public class _01_11 {
    public String Solution(String s) {
        StringBuilder answer = new StringBuilder();
        int cnt = 1;
        s = s + " ";
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
            } else {
                answer.append(s.charAt(i));
                if (cnt > 1) answer.append(cnt);
                cnt = 1;
            }

        }
        return answer.toString();
    }
    public static void main(String[] args) {
        _01_11 T = new _01_11();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.Solution(str));
    }
}
