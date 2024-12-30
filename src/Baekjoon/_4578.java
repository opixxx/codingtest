package Baekjoon;

import java.io.*;
import java.util.*;

public class _4578 {
    static char[][] board;
    static int R, C;
    static List<int[]> target;
    static char[] commands;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int gameNumber = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (R == 0 && C == 0) {
                break;
            }

            board = new char[R][C];
            target = new ArrayList<>();

            int startX = -1;
            int startY = -1;

            for (int i = 0; i < R; i++) {
                String input = br.readLine();
                for (int j = 0; j < C; j++) {
                    char c = input.charAt(j);
                    if (c == '+') {
                        target.add(new int[]{i, j});
                        board[i][j] = '+';
                    }
                    else if (c == 'w') {
                        startX = i;
                        startY = j;
                        board[i][j] = '.';
                    } else if (c == 'W') {
                        target.add(new int[]{i, j});
                        startX = i;
                        startY = j;
                        board[i][j] = '+';
                    } else if (c == 'B') {
                        target.add(new int[]{i, j});
                        board[i][j] = 'b';
                    } else {
                        board[i][j] = c;
                    }

                }
            }

            commands = br.readLine().toCharArray();
            if (solution(startX, startY)) {
                sb.append("Game ").append(gameNumber).append(": complete").append("\n");
            } else {
                sb.append("Game ").append(gameNumber).append(": incomplete").append("\n");
            }
            changeChar();

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            gameNumber++;

        }
        System.out.println(sb);
    }

    static boolean solution(int startX, int startY) {
        int x = startX;
        int y = startY;
        for (int i = 0; i < commands.length; i++) {
            char command = commands[i];
            int nx = x;
            int ny = y;

            if (command == 'U') {
                nx = x - 1; ny = y;
            } else if (command == 'D') {
                nx = x + 1; ny = y;
            } else if (command == 'L') {
                nx = x; ny = y - 1;
            } else if (command == 'R') {
                nx = x; ny = y + 1;
            }

            if (board[nx][ny] == '.') {
                board[x][y] = '.';
                board[nx][ny] = 'w';
                x = nx;
                y = ny;
            } else if (board[nx][ny] == 'b') {
                int nx2 = nx;
                int ny2 = ny;

                if (command == 'U') nx2 = nx - 1;
                else if (command == 'D') nx2 = nx + 1;
                else if (command == 'L') ny2 = ny - 1;
                else if (command == 'R') ny2 = ny + 1;

                if (board[nx2][ny2] == '.' || board[nx2][ny2] == '+') {
                    board[x][y] = '.';
                    board[nx][ny] = 'w';
                    board[nx2][ny2] = 'b';
                    x = nx;
                    y = ny;
                }
            }
            if (isFinish()) {
                return true;
            }
        }
        return false;
    }

    static boolean isFinish() {
        int cnt = 0;
        for (int i = 0; i < target.size(); i++) {
            int[] targetArr = target.get(i);
            int targetX = targetArr[0];
            int targetY = targetArr[1];

            if (board[targetX][targetY] == 'b') {
                cnt++;
            }
        }

        return target.size() - cnt == 0;
    }

    static void changeChar() {
        for (int[] arr : target) {
            int targetX = arr[0];
            int targetY = arr[1];
            if (board[targetX][targetY] == 'b') {
                board[targetX][targetY] = 'B';
            } else if (board[targetX][targetY] == 'w') {
                board[targetX][targetY] = 'W';
            } else if (board[targetX][targetY] == '.') {
                board[targetX][targetY] = '+';
            }
        }
    }
}
