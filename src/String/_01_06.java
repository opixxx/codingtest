package String;

import java.util.Scanner;

public class _01_06 {
    public String Solution(String str) {
        String answer = "";
        for (int i = 0; i < str.length(); i++) {

             if (str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);

        }
        return answer;
    }
    public static void main(String[] args) {
        _01_06 T = new _01_06();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.Solution(str));
    }
}
