package SWEA;

import java.util.HashMap;
import java.util.Scanner;

public class _1244 {
    static String[] arr;
    static int chance, max;
    static HashMap<String, Integer> memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            arr = sc.next().split("");
            chance = sc.nextInt();
            max = 0;
            memo = new HashMap<>();

            dfs(0, 0);
            System.out.println("#" + t + " " + max);
        }
        sc.close();
    }

    private static void dfs(int start, int cnt) {
        String key = String.join("", arr) + " " + cnt; // 배열 상태와 기회 수를 결합한 키
        if (memo.containsKey(key) && memo.get(key) >= cnt) {
            // 이미 같은 상태를 더 적은 기회로 탐색했다면 중단
            return;
        }
        memo.put(key, cnt);

        if (cnt == chance) {
            String result = String.join("", arr);
            max = Math.max(max, Integer.parseInt(result));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                swap(i, j); // 두 숫자 위치 교환
                dfs(i, cnt + 1); // 재귀 호출로 다음 단계 탐색
                swap(i, j); // 원상 복구
            }
        }
    }

    private static void swap(int i, int j) {
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
