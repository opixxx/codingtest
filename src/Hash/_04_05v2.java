package Hash;

import java.util.*;

public class _04_05v2 {
    public int solution(int n, int k, int[] arr) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n ; j++) {
                for (int l = j + 1; l < n ; l++) {
                    list.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        Comparator<Integer> comp = Collections.reverseOrder();
        HashSet<Integer> Hset = new HashSet<>(list);
        ArrayList<Integer> dislist = new ArrayList<>(Hset);
        dislist.sort(comp);
        if (dislist.size() < k - 1) return -1;
        else answer = dislist.get(k - 1);
        return answer;
    }
    public static void main(String[] args) {
        _04_05v2 T = new _04_05v2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, k, arr));


    }
}
