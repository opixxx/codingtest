package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _01_04 {
    public ArrayList<String> Solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            char[] s = x.toCharArray(); // String 을 char 형 배열로 변경
            int left = 0;
            int right = x.length() - 1;
            while (left < right) {
                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
                left++;
                right--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }
        return answer;
       /* \for (String x : str) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);

        }*/

    }


    public static void main(String[] args) {
        _01_04 T = new _01_04();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n 개의 단어 입력
        String[] str = new String[n]; // n 개 string 배열 생성
        for (int i = 0; i < n ; i++) {
            str[i] = sc.next(); // [good, item, study]
        }
        for (String x : T.Solution(n, str)) {
            System.out.println(x);
        }


    }
}
