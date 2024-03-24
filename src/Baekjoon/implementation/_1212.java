package Baekjoon.implementation;

import java.util.Scanner;

public class _1212 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            String numToBinary = Integer.toBinaryString(num);

            if (numToBinary.length() == 3) {
                sb.append(numToBinary);
            } else if (numToBinary.length() == 2 && i != 0) {
                sb.append("0").append(numToBinary);

            } else if (numToBinary.length() == 1 && i != 0) {
                sb.append("00").append(numToBinary);
            } else {
                sb.append(numToBinary);
            }
        }

        System.out.println(sb);


//        Scanner sc = new Scanner(System.in);
//        String num = sc.nextLine();
//
//        BigInteger bigInteger = new BigInteger(num, 8);
//
//        String binaryString = bigInteger.toString(2);
//        System.out.println(binaryString);

    }
}
