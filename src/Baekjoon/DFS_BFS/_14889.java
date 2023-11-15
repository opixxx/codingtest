package Baekjoon.DFS_BFS;

import java.util.Scanner;

public class _14889 {
    static int n;
    static int[][] ability;
    static int[] ch;
    static int min = Integer.MAX_VALUE;
    public void combi(int idx, int count) {
        if (count == n / 2) {
            ability_sum();
            return;

        }

        for (int i = idx; i < n ; i++) {
            if(ch[i] == 0) {
                ch[i] = 1;
                combi(i + 1, count + 1);
                ch[i] = 0;
            }
        }
    }
    public void ability_sum() {
        int team_start = 0;
        int team_link = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if(ch[i] == 1 && ch[j] == 1) {
                    team_start += ability[i][j] + ability[j][i];
                }
                else if(ch[i] == 0 && ch[j] == 0) {
                    team_link += ability[i][j] + ability[j][i];
                }
            }
            
        }
        int val = Math.abs(team_link - team_start);
        min = Math.min(min, val);


    }

    public static void main(String[] args) {
        _14889 T = new _14889();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ch = new int[n];
        ability = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ability[i][j] = sc.nextInt();
            }
        }
        T.combi(0,0);
        System.out.println(min);


    }
}
