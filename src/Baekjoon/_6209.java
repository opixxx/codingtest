package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _6209 {
    static List<Integer> arr;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        arr.add(0);
        arr.add(d);
        for (int i = 1; i <= n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);

        int start = 0;
        int end = d;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (canJump(mid)) {
                start = mid + 1;
                continue;
            }
            end = mid - 1;
        }
        System.out.println(end);
    }

    static boolean canJump(int mid) {
        int rockCount = 0;
        int dis = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) - dis >= mid) {
                dis = arr.get(i);
                continue;
            }
            rockCount++;
        }
        return rockCount <= m;
    }


}
