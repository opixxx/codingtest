package Baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class _2800 {

    private static List<Bracket> bracketList = new ArrayList<>();

    private static TreeSet<String> result = new TreeSet<>();
    private static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') stack.add(i);
            if (arr[i] == ')') bracketList.add(new Bracket(stack.pop(), i));

        }

        comb(0, new boolean[bracketList.size()]);
        result.remove(String.valueOf(arr));

        for (String string : result) {
            System.out.println(string);
        }

    }

    private static void comb(int index, boolean[] selected) {
        if (index == bracketList.size()) {
            StringBuilder sb = new StringBuilder();
            Set<Integer> remove = new HashSet<>();
            for (int i = 0; i < selected.length; i++) {
                if (selected[i]) {
                    Bracket bracket = bracketList.get(i);
                    remove.add(bracket.start);
                    remove.add(bracket.end);

                }
            }

            for (int i = 0; i < arr.length; i++) {
                if (!remove.contains(i)) {
                    sb.append(arr[i]);
                }
            }

            result.add(sb.toString());
            return;
        }

        selected[index] = true;
        comb(index + 1, selected);
        selected[index] = false;
        comb(index + 1, selected);
    }


    static class Bracket {
        int start, end;

        public Bracket(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
