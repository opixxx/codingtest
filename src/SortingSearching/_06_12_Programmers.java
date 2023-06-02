package SortingSearching;
import java.util.Arrays;
import java.util.Scanner;

class _06_12_Programmers {
    public int count(int[] time, int mid) {
        int cnt = 0;
        for (int x : time) {
            cnt += mid / x;
        }
        return cnt;
    }
    public int solution(int n, int m, int[] time) {
        int answer = 0;
        Arrays.sort(time);
        int lt = 0;
        int rt = time[m - 1] * n;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(time, mid) >= n) {
                answer = mid;
                rt = mid - 1;
            }else lt = mid + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        _06_12_Programmers T = new _06_12_Programmers();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] time = new int[m];
        for (int i = 0; i < m; i++) {
            time[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, m, time));
    }

}
