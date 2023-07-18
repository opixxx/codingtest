package Programmers;

class search_5 {
    static int[] ch;
    static int max = 0;
    public void DFS(int k, int L, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++) {
            if (ch[i] == 0 && dungeons[i][0] <= k){
                ch[i] = 1;
                DFS(k - dungeons[i][1], L + 1, dungeons);
                ch[i] = 0;
            }
        }
        if (max < L) {
            max = L;
        }
    }
    public int solution(int k, int[][] dungeons) {

        ch = new int[dungeons.length];
        DFS(k, 0, dungeons);

        return max;
    }
}
