package Baekjoon.implementation;

import java.util.Scanner;

public class _14719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int[] height = new int[w];

        for (int i = 0; i < w; i++) {
            height[i] = sc.nextInt();

        }
        int answer = 0;

        for (int i = 1; i < w - 1; i++) {
            int lt = 0;
            int rt = 0;
            for (int j = 0; j < i; j++) {
                lt = Math.max(lt, height[j]);
            }

            for (int j = i + 1; j < w; j++) {
                rt = Math.max(rt, height[j]);
            }

            if (height[i] < lt && height[i] < rt) {
                answer += Math.min(lt, rt) - height[i];
            }
        }
        System.out.println(answer);
    }
}
