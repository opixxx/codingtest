package SWEA;

import java.util.Scanner;
import java.util.Stack;

public class _1234 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {

            int n = sc.nextInt();
            String number = sc.next();
            char[] arr = number.toCharArray();

            Stack<Character> st = new Stack<>();
            st.push(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                if (!st.isEmpty() && arr[i] == st.peek()) {
                    st.pop();

                }
                else if (st.isEmpty()) {
                    st.push(arr[i]);
                }
                else if (st.peek() != arr[i]) {
                    st.push(arr[i]);
                }

            }
            String answer = "";
            while (!st.isEmpty()) {
                answer += st.pop();
            }
            String result = new StringBuilder(answer).reverse().toString();
            System.out.println("#" + tc + " " + result);
        }

    }
}