package String;

import java.util.Scanner;

public class _01_03 {

    public String Solution(String str) {
        String answer = "";
        int pos;
        int m = 0;
        while ((pos = str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);  // 입력값 : it is time to study 이면 tmp 는 it 이다
            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        } if (str.length() > m) answer = str;
        return answer;
    }

    public static void main(String[] args) {
        _01_03 T = new _01_03();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.Solution(str));

    }
}




// split 을 활용한 방법
/*package String;

        import java.util.Scanner;

public class _01_03 {

    public String Solution(String str) {
        String answer = "";
        int m = 0; // m 에다가 가장 최솟값으로 설정
        String[] s = str.split(" "); // 공백으로 나눠서 string 배열에다가 저장
        for (String x : s) {
            int len = x.length(); //
            if (len > m) {
                m = len;
                answer = x;   // d=
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        _01_03 T = new _01_03();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.Solution(str));

    }
}*/
