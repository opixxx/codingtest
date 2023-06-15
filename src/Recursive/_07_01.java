package Recursive;

import java.util.Scanner;

public class _07_01 {
    public void DFS(int n) {
        if (n == 0) return;
        else {
            DFS(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        _07_01 T = new _07_01();
        Scanner sc = new Scanner(System.in);
        T.DFS(3);
    }
}
