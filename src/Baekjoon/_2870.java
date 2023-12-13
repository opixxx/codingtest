package Baekjoon;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _2870 {
    static List<BigInteger> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        for (int i = 0; i < n; i++) {
            String input = sc.next();
            getNumber(input);

        }
        Collections.sort(list);
        for (BigInteger num : list) {
            System.out.println(num);
        }
    }

    public static void getNumber(String input) {
        char[] chars = input.toCharArray();
        String number = "";
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                number += chars[i];
            } else {
                if (number.length() > 0) {
                    list.add(new BigInteger(number));
                    number = "";
                }
            }
        }
        if (number.length() > 0) {
            list.add(new BigInteger(number));
        }
    }

}
