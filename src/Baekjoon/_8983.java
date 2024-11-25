package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _8983 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); //사대 수
        int n = Integer.parseInt(st.nextToken()); //동물 수
        int l = Integer.parseInt(st.nextToken()); //사정 거리

        int[] arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Animal[] animals = new Animal[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            animals[i] = new Animal(x, y);
        }

        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < n; i++) {
            int lt = 0;
            int rt = m - 1;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                int dis = Math.abs(arr[mid] - animals[i].x) + animals[i].y;

                if (dis <= l) {
                    count++;
                    break;
                }

                if (animals[i].x > arr[mid]) {
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }
        }
        System.out.println(count);
    }

    static class Animal {
        int x;
        int y;

        public Animal(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
