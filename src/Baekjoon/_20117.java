package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class _20117 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = IntStream.range(0, n).map(i -> Integer.parseInt(st.nextToken()))
                .boxed()
                .sorted((a,b) -> b - a)
                .mapToInt(Integer::intValue)
                .toArray();

        int sum =IntStream.range(0, (n + 1) / 2).map(i -> i < n / 2 ? arr[i] * 2 : arr[i]).sum();
       /* if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                sum = sum + (arr[i] * 2);
            }
        } else {
            for (int i = 0; i < n / 2; i++) {
                sum = sum + (arr[i] * 2);
            }
            sum += arr[n / 2];
        }*/
        System.out.println(sum);
    }
}
