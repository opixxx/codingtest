package Programmers;

class search_6 {
    static int min, N;
    static int[][] map;
    static int[] ch;

    public int DFS(int l) {
        ch[l] = 1;
        int child = 1;
        for (int i = 1; i <= N; i++){
            if(ch[i] == 0 && map[l][i] == 1) {
                child += DFS(i);
            }
        }
        min = Math.min(min, Math.abs(child - (N - child)));
        return child;
    }

    public int solution(int n, int[][] wires) {
        ch = new int[n + 1];
        N = n;
        min = n;
        map = new int[n + 1][n + 1];
        for (int [] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            map[a][b] = map[b][a] = 1;
        }
        DFS(1);

        return min;
    }
}