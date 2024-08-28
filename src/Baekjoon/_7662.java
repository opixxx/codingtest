package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class _7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            int t = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < t; j++) {
                String[] input = br.readLine().split(" ");
                String command = input[0];
                int num = Integer.parseInt(input[1]);

                if (command.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if (command.equals("D")) {
                    if (map.isEmpty()) {
                        continue;
                    }
                    int key;
                    if (num == 1) {
                        key = map.lastKey();

                    } else {
                        key = map.firstKey();
                    }
                    if (map.put(key, map.get(key) - 1) == 1) {
                        map.remove(key);
                    }
                }

            }
            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}
