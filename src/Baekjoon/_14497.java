package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14497 {
    static int N, M, x1, y1, x2, y2, cnt;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] map;
    static int[][] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        chk = new int[N][M];

        st = new StringTokenizer(br.readLine(), " ");
        x1 = Integer.parseInt(st.nextToken()) - 1;
        y1 = Integer.parseInt(st.nextToken()) - 1;
        x2 = Integer.parseInt(st.nextToken()) - 1;
        y2 = Integer.parseInt(st.nextToken()) - 1;


        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }


        jump();
        System.out.println(chk[x2][y2]);
    }

    private static void jump() {
        Queue<Point> q = new LinkedList<>();


        q.add(new Point(x1, y1));
        chk[x1][y1] = 1;


        while (map[x2][y2] == '#') {
            cnt++;
            Queue<Point> tmp = new LinkedList<>();
            while (!q.isEmpty()) {
                Point cur = q.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = cur.x + dy[k];
                    int ny = cur.y + dx[k];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && chk[nx][ny] == 0) {
                        chk[nx][ny] = cnt;
                        if (map[nx][ny] != '0') {
                            map[nx][ny] = '0';
                            tmp.add(new Point(nx, ny));
                        } else {
                            q.offer(new Point(nx, ny));
                        }
                    }
                }
            }
            q = tmp;
        }
    }
}