package SWEA;

import java.util.Arrays;

public class _3131 {
    public static void main(String[] args) {
        StringBuilder answer = new StringBuilder();
        int n = 1000000;
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }

            }
        }
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                answer.append(i).append(" ");
            }
        }
        System.out.println(answer);

    }
}
