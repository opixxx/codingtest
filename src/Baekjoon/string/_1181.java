package Baekjoon.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            if (!list.contains(input)) {
                list.add(input);
            }
        }

        Collections.sort(list, (s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length(); // 음수면 s1 이 s2 보다 짧다 양수면 s1 이 s2 보다 크다
            } else {
                return s1.compareTo(s2); // 첫 번째 문자열이 두 번째 문자열보다 사전적으로 앞서면 음수, 같으면 0, 뒤면 양수
            }
        });

        for (String s : list) {
            System.out.println(s);
        }
    }
}
