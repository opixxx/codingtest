package Baekjoon.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Escape {
    int x;
    int y;

    public Escape(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class _3055 {
    static char[][] map;
    static Queue<Escape> hedgehog;
    static Queue<Escape> water;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int r, c, answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        hedgehog = new LinkedList<>();
        water = new LinkedList<>();

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String input = sc.next();
            for (int j = 0; j < c; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'S') {
                    hedgehog.offer(new Escape(i, j));
                }
                if (map[i][j] == '*') {
                    water.offer(new Escape(i, j));
                }
            }
        }
        answer = Integer.MAX_VALUE;
        BFS();
        if (answer == Integer.MAX_VALUE) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(answer);
        }
    }

    public static void BFS() {
        int time = 0;
        while (!hedgehog.isEmpty()) {
            int waterSize = water.size();
            for (int i = 0; i < waterSize; i++) {
                Escape tmp = water.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        water.offer(new Escape(nx, ny));
                    }
                }

            }

            int hedgehogSize = hedgehog.size();

            for (int i = 0; i < hedgehogSize; i++) {
                Escape tmp = hedgehog.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                        if (map[nx][ny] == 'D') {
                            answer = time + 1;
                            return;
                        }
                        if (map[nx][ny] == '.') {
                            map[nx][ny] = 'S';
                            hedgehog.offer(new Escape(nx, ny));
                        }
                    }
                }
            }
            time++;
        }

    }
}
