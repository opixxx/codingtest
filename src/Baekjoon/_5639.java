package Baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5639 {
    static class Node {
        int num;
        Node lt, rt;

        public Node(int n) {
            this.num = n;
        }

        void insert(int n) {
            if (n > this.num) { //오른쪽 자식
                if (this.rt == null) {
                    this.rt = new Node(n);
                } else {
                    this.rt.insert(n);
                }
            } else { //왼쪽 자식
                if (this.lt == null) {
                    this.lt = new Node(n);
                } else {
                    this.lt.insert(n);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));

        while (true) {
            String input = br.readLine();
            if (input == null || input.isEmpty()) {
                break;
            }

            int value = Integer.parseInt(input);
            root.insert(value);
        }
        dfs(root);
    }
    private static void dfs(Node node) {
        if (node == null) {
            return;
        }
        dfs(node.lt);
        dfs(node.rt);

        System.out.println(node.num);
    }
}
