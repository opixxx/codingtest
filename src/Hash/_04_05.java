package Hash;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class _04_05 {
    public int solution(int n, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder()); // 내림차순 정렬
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n ; j++) {
                for (int l = j + 1; l < n ; l++) {
                    Tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;

        for (int x : Tset) {
            cnt++;
            if (cnt == k) return x;
        }
        return answer;
    }
    public static void main(String[] args) {
        _04_05 T = new _04_05();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, k, arr));


    }
}
