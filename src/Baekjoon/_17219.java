package Baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String address = st.nextToken();
            String password = st.nextToken();

            map.put(address, password);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < m; i++) {
            String findAddress = br.readLine();
            String password = map.get(findAddress);
            sb.append(password).append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }
}
