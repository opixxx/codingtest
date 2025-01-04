package Programmers;

import java.util.HashSet;

public class 연속_부분_수열_합의_개수 {
    public int solution(int[] elements) {
        int length = elements.length;
        int[] prefixSum = new int[length * 2 + 1];
        int[] tmp = new int[length * 2];

        // 배열 확장
        for (int i = 0; i < length * 2; i++) {
            tmp[i] = elements[i % length];
        }

        // 누적합 계산
        for (int i = 1; i <= tmp.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + tmp[i - 1];
        }

        HashSet<Integer> set = new HashSet<>();


        for (int subLength = 1; subLength <= length; subLength++) {
            for (int start = 0; start < length; start++) {
                int end = start + subLength;
                int sum = prefixSum[end] - prefixSum[start];
                set.add(sum);
            }
        }

        return set.size();
    }
}
