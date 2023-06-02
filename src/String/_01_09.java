package String;

import java.util.Scanner;

public class _01_09 {
    public int Solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (char x : s.toCharArray()) {
            if (Character.isDigit(x)) answer = answer + x;
        }
        return Integer.parseInt(answer);

    }


    public static void main(String[] args) {
        _01_09 T = new _01_09();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.Solution(str));

    }
}
