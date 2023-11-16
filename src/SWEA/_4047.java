package SWEA;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class _4047 {
    static Map<String, Integer> map = new LinkedHashMap<>();

    public static void setMap() {
        map.put("S", 0);
        map.put("D", 0);
        map.put("H", 0);
        map.put("C", 0);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            setMap();
            boolean flag = false;

            Set<String> set = new HashSet<>();
            String s = sc.next();
            for (int i = 0; i < s.length(); i += 3) {
                String tmp = s.substring(i, i + 3);
                if (set.contains(tmp)) {
                    System.out.println("#" + tc + " "+ "ERROR");
                    flag = true;
                    break;
                }
                set.add(tmp);
                String card = tmp.substring(0, 1);
                map.replace(card, map.get(card) + 1);


            }
            if (!flag) {
                System.out.print("#" + tc + " ");
                for (String a : map.keySet()) {
                    System.out.print((13 - map.get(a)) + " ");
                }
                System.out.println();
                map.clear();

            }


        }
    }
}
