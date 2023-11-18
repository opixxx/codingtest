package SWEA;

import java.util.ArrayList;
import java.util.Scanner;


public class _5986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for(int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
            int cnt = 0;
            ArrayList <Integer> a = new ArrayList<>();

            for(int i = 2; i <= n; i++) {
                int flag = 0;
                for(int j = 2; j <= Math.sqrt(i); j++) {
                    if(i % j == 0) {
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0)
                    a.add(i);
            }
            for(int i = 0; i < a.size(); i++) {
                for(int j = i; j < a.size(); j++) {
                    if(a.get(i) + a.get(j) >= n)
                        break;
                    for(int k = j; k < a.size(); k++) {
                        int sum = a.get(i) + a.get(j) + a.get(k);

                        if(sum == n) {
                            cnt++;
                        }
                    }
                }
            }

            System.out.println("#" + t + " " + cnt);
        }
    }
}
