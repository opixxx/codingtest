package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        String[] arr = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = br.readLine();
            map.put(arr[i], i);
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (isStringNumber(str)) {
                int index = Integer.parseInt(str);
                answer.append(arr[index]);
            } else {
                answer.append(map.get(str));
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }

    public static boolean isStringNumber(String str) {
        try {
            int a = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
