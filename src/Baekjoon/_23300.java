package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _23300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int currentPage = 0;
        Deque<Integer> back = new ArrayDeque<>();
        Deque<Integer> front = new ArrayDeque<>();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "B" :
                    if (!back.isEmpty()) {
                        front.addFirst(currentPage);
                        currentPage = back.removeLast();
                    }
                    break;
                case "F":
                    if (!front.isEmpty()) {
                        back.addLast(currentPage);
                        currentPage = front.removeFirst();
                    }
                    break;
                case "A":
                    front.clear();
                    if (currentPage != 0) {
                        back.addLast(currentPage);
                    }
                    currentPage = Integer.parseInt(st.nextToken());
                    break;
                case "C":
                    Deque<Integer> temp = new ArrayDeque<>();
                    Integer prev = null;
                    for (Integer page : back) {
                        if (!page.equals(prev)) {
                            temp.addLast(page);
                        }
                        prev = page;
                    }
                    back = temp;
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(currentPage).append("\n");
        sb.append(back.isEmpty() ? "-1" : back.stream().sorted((a, b) -> -1).map(String::valueOf).collect(Collectors.joining(" ")));
        sb.append("\n");
        sb.append(front.isEmpty() ? "-1" : front.stream().map(String::valueOf).collect(Collectors.joining(" ")));

/*        StringBuilder sb = new StringBuilder();
        sb.append(currentPage).append("\n");
        if (back.isEmpty()) {
            sb.append(-1);
        } else {
            while (!back.isEmpty()) {
                sb.append(back.pollLast()).append(" ");
            }
        }
        sb.append("\n");
        if (front.isEmpty()) {
            sb.append(-1);
        } else {
            while (!front.isEmpty()) {
                sb.append(front.pollFirst()).append(" ");
            }
        }*/

        System.out.println(sb);
    }
}
