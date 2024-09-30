package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1991 {
    static Node rootNode = new Node('A', null, null);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            createNode(rootNode, root, left, right);

        }
        preOrder(rootNode);
        System.out.println();
        inOrder(rootNode);
        System.out.println();
        postOrder(rootNode);
    }

    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void createNode(Node node, char root, char left, char right) {
        if (node.data == root) {
            node.left = (left == '.' ? null : new Node(left, null, null));
            node.right = (right == '.' ? null : new Node(right, null, null));
        } else {
            if (node.left != null) {
                createNode(node.left, root, left, right);
            }
            if (node.right != null) {
                createNode(node.right, root, left, right);
            }
        }
    }

    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);

    }

    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);

    }
}
