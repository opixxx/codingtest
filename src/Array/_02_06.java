package Array;
import java.util.Scanner;

public class _02_06 {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        Scanner sa = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            int num = sa.nextInt(); // 자연수 입력 받기

            // 자연수를 뒤집기 위해 StringBuilder 클래스를 사용
            StringBuilder sb = new StringBuilder(String.valueOf(num));
            sb.reverse(); // StringBuilder 클래스의 reverse() 메서드를 사용하여 뒤집기

            // 뒤집은 수가 소수인지 확인하기
            int reverseNum = Integer.parseInt(sb.toString());
            boolean isPrime = true; // 소수 여부를 저장할 변수

            if (reverseNum <= 1) { // 뒤집은 수가 1보다 작거나 같으면 소수가 아님
                isPrime = false;
            } else { // 뒤집은 수가 2 이상인 경우 소수 여부 확인
                for (int j = 2; j <= Math.sqrt(reverseNum); j++) {
                    if (reverseNum % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            // 소수이면 출력하기
            if (isPrime) {
                if (answer.length() > 0) answer.append(" ");
                answer.append(reverseNum);

            }
        }
        return answer.toString().trim();
    }



    public static void main(String[] args) {
        _02_06 T = new _02_06();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(T.solution(n));


    }
}

