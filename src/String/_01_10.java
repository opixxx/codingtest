package String;

import java.util.Scanner;

public class _01_10 {
    public int[] Solution (String s, char t){
        int[] answer = new int[s.length()];
        int p = 1000;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }
        p = 1000;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if (s.charAt(i) == t) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }

        }
    return answer;
    }

    public static void main(String[] args) {
        _01_10 T = new _01_10();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        for (int x : T.Solution(str, c)) {
            System.out.print(x + " ");
        }
    }
}
