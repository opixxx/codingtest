package Programmers;
class DFSBFS_2 {
    public void DFS(int i, int[][] computers, boolean[] visited) {
        visited[i] = true;

        for(int j = 0; j < computers.length; j++) {
            if(i != j && computers[i][j] == 1 && !visited[j]) {
                DFS(j, computers, visited);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            visited[i] = false;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer++;
                DFS(i, computers, visited);
            }
        }
        return answer;
    }
}