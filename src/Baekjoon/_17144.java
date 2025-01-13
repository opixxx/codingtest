package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17144 {
    static int[][] arr, tmp;
    static int r, c;
    static int[] air;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        arr = new int[r][c];
        tmp = new int[r][c];

        air = new int[2];
        int index = 0;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    air[index++] = i;
                }
            }
        }


        while (t-- > 0) {
            step1();
            step2();
        }

        System.out.print(getAnswer());

    }

    static int getAnswer() {
        int answer = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] > 0) {
                    answer += arr[i][j];
                }
            }
        }

        return answer;

    }

    public static void copyArr(int[][] target, int[][] org){
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                target[i][j] = org[i][j];
            }
        }
    }
    static void step1() {
        tmp = new int[r][c];

        tmp[air[0]][0] = -1;
        tmp[air[1]][0] = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] > 0) {
                    int value = arr[i][j] / 5;
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < r && ny >= 0 && ny < c && arr[nx][ny] != -1) {
                            count++;
                            tmp[nx][ny] += value;
                        }
                    }
                    tmp[i][j] += arr[i][j] - (value * count);
                }
            }
        }
        copyArr(arr, tmp);
    }

    static void step2() {
        int upper = air[0];
        int lower = air[1];

        for (int i = upper - 1; i > 0; i--) {
            arr[i][0] = arr[i - 1][0];
        }
        for (int i = 0; i < c - 1; i++) {
            arr[0][i] = arr[0][i + 1];
        }
        for (int i = 0; i < upper; i++) {
            arr[i][c - 1] = arr[i + 1][c - 1];
        }
        for (int i = c - 1; i > 1; i--) {
            arr[upper][i] = arr[upper][i - 1];
        }
        arr[upper][1] = 0;


        for (int i = lower + 1; i < r - 1; i++) {
            arr[i][0] = arr[i + 1][0];
        }
        for (int i = 0; i < c - 1; i++) {
            arr[r - 1][i] = arr[r - 1][i + 1];
        }
        for (int i = r - 1; i > lower; i--) {
            arr[i][c - 1] = arr[i - 1][c - 1];
        }
        for (int i = c - 1; i > 1; i--) {
            arr[lower][i] = arr[lower][i - 1];
        }
        arr[lower][1] = 0;
    }
}
