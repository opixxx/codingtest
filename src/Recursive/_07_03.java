package Recursive;

public class _07_03 {
    public int DFS(int n) {
        if (n == 1) return 1;
        else return n * DFS(n -1);

    }
    public static void main(String[] args) {
        _07_03 T = new _07_03();
        System.out.println(T.DFS(5));
    }
}
