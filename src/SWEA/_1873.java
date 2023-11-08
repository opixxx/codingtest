package SWEA;

import java.util.Scanner;

public class _1873 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1}; //상하좌우
    static char[][] map;
    static int h, w;
    static int playerX, playerY;
    public static void getPlayerLocation() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == '<' || map[i][j] == 'v' || map[i][j] == '>' || map[i][j] == '^') {
                    playerX = i;
                    playerY = j;

                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            h = sc.nextInt();
            w = sc.nextInt();
            map = new char[h][w];
            for (int i = 0; i < h; i++) {
                map[i] = sc.next().toCharArray();
            }
            int n = sc.nextInt();
            char[] input = sc.next().toCharArray();

            getPlayerLocation();


            for (int i = 0; i < n; i++) {
                switch (input[i]) {
                    case 'U':
                        up();
                        break;
                    case 'D':
                        down();
                        break;
                    case 'L':
                        left();
                        break;
                    case 'R':
                        right();
                        break;
                    case 'S':
                        shoot();
                        break;
                }
            }
            System.out.print("#" + t + " ");
            for (int i = 0; i < h; i++) {
                System.out.println(map[i]);
            }

        }
    }

    private static void shoot() {
        switch (map[playerX][playerY]) {
            case '^':
                for (int nx = playerX - 1; nx >= 0; nx--) {
                    if (map[nx][playerY] == '*') {
                        map[nx][playerY] = '.';
                        break;
                    } else if (map[nx][playerY] == '#') {
                        break;
                    }
                }
                break;
            case 'v':
                for (int nx = playerX + 1; nx < h; nx++) {
                    if (map[nx][playerY] == '*') {
                        map[nx][playerY] = '.';
                        break;
                    } else if (map[nx][playerY] == '#') {
                        break;
                    }
                }
                break;
            case '<':
                for (int ny = playerY - 1; ny >= 0; ny--) {
                    if (map[playerX][ny] == '*') {
                        map[playerX][ny] = '.';
                        break;
                    } else if (map[playerX][ny] == '#') {
                        break;
                    }
                }
                break;
            case '>':
                for (int ny = playerY + 1; ny < w; ny++) {
                    if (map[playerX][ny] == '*') {
                        map[playerX][ny] = '.';
                        break;
                    } else if (map[playerX][ny] == '#') {
                        break;
                    }
                }
                break;
        }
    }


    private static void up() {
        int nx = playerX + dx[0];
        int ny = playerY + dy[0];

        if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == '.') {
            map[playerX][playerY] = '.';
            playerX = nx;
            playerY = ny;
        }
        map[playerX][playerY] = '^';
    }
    private static void down() {
        int nx = playerX + dx[1];
        int ny = playerY + dy[1];
        if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == '.') {
            map[playerX][playerY] = '.';
            playerX = nx;
            playerY = ny;
        }
        map[playerX][playerY] = 'v';

    }
    private static void left() {
        int nx = playerX + dx[2];
        int ny = playerY + dy[2];
        if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == '.') {
            map[playerX][playerY] = '.';
            playerX = nx;
            playerY = ny;
        }
        map[playerX][playerY] = '<';
    }
    private static void right() {
        int nx = playerX + dx[3];
        int ny = playerY + dy[3];
        if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == '.') {
            map[playerX][playerY] = '.';
            playerX = nx;
            playerY = ny;
        }
        map[playerX][playerY] = '>';
    }

}
