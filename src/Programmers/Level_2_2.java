package Programmers;

public class Level_2_2 {
    public String solution(String s) {
        String answer = "";
        String[] tmp = s.toLowerCase().split(" ");
        for (int i = 0; i < tmp.length; i++) {
            String now = tmp[i];

            if (tmp[i].length() == 0) {
                answer += " ";

            }
            else {
                answer += now.substring(0,1).toUpperCase();
                answer += now.substring(1, now.length());
                answer += " ";
            }

        }
        if (s.charAt(s.length() - 1) == ' ') return answer;

        return answer.substring(0,answer.length()-1);



    }
    public static void main(String[] args) {
        Level_2_2 T = new Level_2_2();

        String str = "3people  unFollowed me ";

        System.out.println(T.solution(str));

    }

}
