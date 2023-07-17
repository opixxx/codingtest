package Programmers;
import java.util.*;

class sort_2 {
    public String solution(int[] numbers) {
        String answer = "";
        String[] numberStrings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numberStrings[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numberStrings, (a, b) -> (b + a).compareTo(a + b));

        if (numberStrings[0].equals("0")) {
            return "0";
        }

        for (String number : numberStrings) {
            answer += number;
        }

        return answer;
    }
}


