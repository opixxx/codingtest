package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _19538 {
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N + 1];
        int[] neighbor = new int[N + 1];

        Arrays.fill(time, -1);


        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            while (true) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 0) {
                    break;
                }
                list.get(i).add(input);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int first = Integer.parseInt(st.nextToken());
            q.offer(first);
            time[first] = 0;
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : list.get(cur)) {
                neighbor[next]++;

                if (time[next] == -1 && (list.get(next).size() + 1) / 2 <= neighbor[next]) {
                    q.offer(next);
                    time[next] = time[cur] + 1;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(time[i] + " ");
        }
    }
}
