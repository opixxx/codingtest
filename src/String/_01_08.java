package String;

import java.util.Scanner;

public class _01_08 {

    public String Solution(String s) {
        String answer = "NO";
        StringBuilder sb = new StringBuilder();
        s = s.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(s).reverse().toString();
        if (s.equals(tmp)) return "YES";

        return answer;
    }

    public static void main(String[] args) {
        _01_08 T = new _01_08();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.printf(T.Solution(str));
    }
}
