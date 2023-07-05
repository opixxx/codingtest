package Greedy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Meeting implements Comparable<Meeting>{
    public int start, end;
    Meeting (int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Meeting o) {
        if (this.end == o.end) return this.start - o.start; // 오름차순
        else return this.end - o.end;
    }
}
public class _09_02 {
    public int solution(ArrayList<Meeting> arr) {
        int cnt = 0;
        Collections.sort(arr);
        int time = 0;
        for (Meeting ob : arr) {
            if (ob.start >= time) {
                cnt++;
                time = ob.end;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        _09_02 T = new _09_02();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Meeting> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr.add(new Meeting(s, e));
        }
        System.out.println(T.solution(arr));

    }
}
