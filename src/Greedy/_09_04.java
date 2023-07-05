package Greedy;

import java.util.*;

class Company implements Comparable<Company>{
    public int m, d;
    Company(int m, int d) {
        this.m = m;
        this.d = d;
    }
    @Override
    public int compareTo(Company o) {
        return o.d - this.d; // 내림차순
    }
}
public class _09_04 {
    public int solution(int n, ArrayList<Company> arr) {
        int answer = 0;
        Collections.sort(arr);
        int max = arr.get(0).d;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) { //j 의 초기값을 외부에 선언해서 다시 j for문으로 돌아와도 0부터 시작하지 않고 이어서 for 문 진행한다.
                if (arr.get(j).d < i) break;
                else pQ.offer(arr.get(j).m);
            }
            if (!pQ.isEmpty()) answer += pQ.poll();
        }
        return answer;
    }
    public static void main(String[] args) {
        _09_04 T = new _09_04();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Company> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            arr.add(new Company(m, d));
        }
        System.out.println(T.solution(n, arr));
    }
}
