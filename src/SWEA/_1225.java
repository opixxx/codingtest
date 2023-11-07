package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            int test = sc.nextInt();
            Queue<Integer> q = new LinkedList<>();

            for (int i = 0; i < 8; i++) {
                q.offer(sc.nextInt());
            }
            boolean flag = false;
            while (!flag) {
                for (int i = 1; i <= 5; i++) {
                    int num = q.poll() - i;
                    if (num <= 0) {
                        q.offer(0);
                        flag = true;
                        break;
                    }
                    q.offer(num);
                }
            }
            System.out.print("#" + t + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(q.poll() + " ");
            }
            System.out.println();

        }

    }
}
