package Programmers;
class DFSBFS_3 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;
    public void BFS(int L, int x, int y, int[][] maps){
        if(L >= answer) return;
        if(x == maps.length - 1 && y == maps[0].length - 1) {
            answer = Math.min(answer, L);
        } else {
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx <= maps.length - 1 && ny >= 0 && ny <= maps[0].length -1 && maps[nx][ny] == 1) {
                    maps[nx][ny] = 0;
                    BFS(L + 1, nx, ny, maps);
                    maps[nx][ny] = 1;
                }
            }
        }
    }
    public int solution(int[][] maps) {
        BFS(1, 0, 0, maps);
        if (answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }
}