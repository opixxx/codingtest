package String;


import java.util.Scanner;

public class _01_07 {
    public String Solution(String str) {
        String answer = "YES";
        str = str.toUpperCase();
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) answer = "NO";

        }
        return answer;
    }

    public static void main(String[] args) {
        _01_07 T = new _01_07();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.Solution(str));
    }
}
