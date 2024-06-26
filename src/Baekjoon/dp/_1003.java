package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Fibo {
    int zero;
    int one;

    public Fibo(int zero, int one) {
        this.zero = zero;
        this.one = one;
    }
}
public class _1003 {
    static List<Fibo> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int t = Integer.parseInt(br.readLine());
        list.add(new Fibo(1, 0));
        list.add(new Fibo(0, 1));

        for (int i = 2; i <= 40; i++) {
            Fibo fibo1 = list.get(i - 2);
            Fibo fibo2 = list.get(i - 1);

            list.add(new Fibo(fibo1.zero + fibo2.zero, fibo1.one + fibo2.one));
        }

        for (int i = 0; i < t; i++) {
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());

            int zero = list.get(n).zero;
            int one = list.get(n).one;
            sb.append(zero).append(" ").append(one);
            System.out.println(sb);
        }
    }
}
