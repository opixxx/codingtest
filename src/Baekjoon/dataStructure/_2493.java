package Baekjoon.dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
    int index;
    int height;

    public Top(int index, int height) {
        this.index = index;
        this.height = height;
    }
}
public class _2493 {
    static Stack<Top> st = new Stack<>();
    static int top;
    static int[] answer;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        answer = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            top = Integer.parseInt(st.nextToken());
            solution(i);
        }

        for (int a : answer) {
            sb.append(a).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void solution(int index) {
        while (!st.isEmpty() && st.peek().height < top) {
            st.pop();
        }

        if (st.isEmpty()) {
            st.push(new Top(index, top));
            answer[index] = 0;
        } else {
            answer[index] = st.peek().index + 1;
        }
        st.push(new Top(index, top));

    }
}
