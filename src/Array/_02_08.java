package Array;
import java.util.Scanner;

public class _02_08 {
    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[i]) cnt++;
            }
            answer[i] = cnt;
        }
        return answer;
    }


    public static void main(String[] args) {
        _02_08 T = new _02_08();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }

    }
}
