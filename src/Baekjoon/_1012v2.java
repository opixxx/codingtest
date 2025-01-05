package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class _1012v2 {
    static int[][] arr;
    static int[][] ch;
    static int N, M, K;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        IntStream.range(0, T).forEach(t -> {
            try {
                StringTokenizer st = new StringTokenizer(br.readLine());
                M = Integer.parseInt(st.nextToken());
                N = Integer.parseInt(st.nextToken());
                K = Integer.parseInt(st.nextToken());

                arr = new int[N][M];
                ch = new int[N][M];

                // 입력 데이터를 처리
                IntStream.range(0, K).forEach(i -> {
                    try {
                        StringTokenizer st1 = new StringTokenizer(br.readLine());
                        int X = Integer.parseInt(st1.nextToken());
                        int Y = Integer.parseInt(st1.nextToken());
                        arr[Y][X] = 1;
                    } catch (IOException e) {}
                });

                // BFS 호출 및 영역 개수 카운트
                long count = IntStream.range(0, N)
                        .flatMap(i -> IntStream.range(0, M)
                                .filter(j -> arr[i][j] == 1 && ch[i][j] == 0)
                                .map(j -> {
                                    bfs(i, j);
                                    return 1; // BFS 호출 후 1을 반환
                                }))
                        .count();

                sb.append(count).append("\n");
            } catch (IOException e) {}
        });

        System.out.print(sb);
    }

    static void bfs(int x, int y) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(x, y));
        ch[x][y] = 1;

        while (!q.isEmpty()) {
            var cur = q.poll();

            IntStream.range(0, 4).forEach(i -> {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && ch[nx][ny] == 0 && arr[nx][ny] == 1) {
                    ch[nx][ny] = 1;
                    q.offer(new Point(nx, ny));
                }
            });
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}