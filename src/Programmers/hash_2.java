package Programmers;
import java.util.*;
class hash_2 {
    public int solution(int[] nums) {
        int answer = 0;
        int num = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        answer = Math.min(set.size(), num);

        return answer;
    }
}