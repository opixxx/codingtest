package Baekjoon.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Time implements Comparable<Time> {
    int start;
    int end;
    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if (this.end == o.end) {
            return this.start - o.start; // 오름차순
        } else {
            return this.end - o.end;
        }

    }
}
public class _1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        List<Time> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Time(s, e));
        }
        Collections.sort(list);
        int endTime = 0;
        for (Time t : list) {
            if (t.start >= endTime) {
                cnt++;
                endTime = t.end;
            }
        }
        System.out.println(cnt);
    }
}
