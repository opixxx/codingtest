package Baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6550 {
    static String input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            input = br.readLine();
            if (input == null) {
                break;
            }

            st = new StringTokenizer(input);

            String s = st.nextToken();
            String t = st.nextToken();

            int index = 0;

            for (int i = 0; i < t.length(); i++) {
                if (s.charAt(index) == t.charAt(i)) {
                    index++;
                }
                if (index == s.length()) {
                    break;
                }
            }

            if (index == s.length()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
