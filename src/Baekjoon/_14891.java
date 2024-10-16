package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14891 {
    static int[][] arr = new int[4][8];
    static int[] direction;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine()); //회전 수

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken()) - 1; //회전할 바뀌 번호
            int dir = Integer.parseInt(st.nextToken()); //회전 방향 1 -> 시계, -1 -> 반시계

            direction = new int[4];
            direction[number] = dir;
            checkTurn(number);
            turn();
        }
        int answer = 0;
        if (arr[0][0] == 1) answer += 1;
        if (arr[1][0] == 1) answer += 2;
        if (arr[2][0] == 1) answer += 4;
        if (arr[3][0] == 1) answer += 8;
        System.out.println(answer);

    }

    private static void turn() {
        int tmp = 0;
        for (int i = 0; i < 4; i++) {
            if (direction[i] == 1) { //시계방향
                tmp = arr[i][7];
                for (int j = 7; j > 0; j--) {
                    arr[i][j] = arr[i][j - 1];
                }
                arr[i][0] = tmp;
            } if (direction[i] == -1){
                tmp = arr[i][0];
                for (int j = 0; j < 7; j++) {
                    arr[i][j] = arr[i][j + 1];
                }
                arr[i][7] = tmp;
            }
        }
    }

    private static void checkTurn(int number) {
        for (int i = number - 1; i >= 0; i--) {
            if (arr[i][2] != arr[i + 1][6]) {
                direction[i] = -direction[i + 1];
            } else {
                break;
            }
        }

        for (int i = number + 1; i < 4; i++) {
            if (arr[i][6] != arr[i - 1][2]) {
                direction[i] = -direction[i - 1];
            } else {
                break;
            }
        }
    }

}
