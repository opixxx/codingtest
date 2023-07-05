package Greedy;

import java.util.*;

class Time_1 implements Comparable<Time_1> {
    public int t;
    public char s;
    Time_1(int t, char s) {
        this.t = t;
        this.s = s;
    }
    @Override
    public int compareTo(Time_1 o) {
        if(this.t == o.t) return this.s - o.s;
        else return this.t - o.t;
    }
}
public class _09_03 {
    public int solution (ArrayList<Time_1> arr) {
        int cnt = 0;
        int answer = 0;
        Collections.sort(arr);
        for (Time_1 ob : arr){
            if (ob.s == 's') {
                cnt++;
            }
            else if(ob.s == 'e') {
                cnt--;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
}
    public static void main(String[] args) {
        _09_03 T = new _09_03();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time_1> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int st = sc.nextInt();
            int et = sc.nextInt();
            arr.add(new Time_1(st, 's'));
            arr.add(new Time_1(et, 'e'));
        }
        System.out.println(T.solution( arr));

    }
}
