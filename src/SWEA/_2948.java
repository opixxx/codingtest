package SWEA;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _2948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            Set<String> set = new HashSet<>();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int count = 0;
            for (int i = 0; i < n; i++) {
                set.add(sc.next());
            }
            for (int i = 0; i < m; i++) {
                if (!set.add(sc.next())) {
                    count++;
                }

            }

            System.out.println("#" + tc + " " + count);
        }
    }
}
