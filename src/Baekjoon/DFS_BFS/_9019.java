package Baekjoon.DFS_BFS;
import java.util.*;

class DSLR {
    public int result;
    public String command;
    DSLR(int result, String command) {
        this.result = result;
        this.command = command;
    }

}
public class _9019 {
    static boolean[] ch = new boolean[10000];
    static ArrayList<String> list = new ArrayList<>();
    public void BFS(int input, int output) {
        Arrays.fill(ch, false);
        Queue<DSLR> q = new LinkedList<>();

        q.offer(new DSLR(input, ""));

        while(!q.isEmpty()) {

            DSLR tmp = q.poll();
            if (tmp.result == output) {
                list.add(tmp.command);
                break;
            }
            for (int i = 0; i < 4; i++) {
                if(i == 0) {
                    int next_result = (tmp.result * 2) % 10000;
                    if (!ch[next_result]) {
                        String next_command = tmp.command + 'D';
                        ch[next_result] = true;
                        q.offer(new DSLR(next_result, next_command));
                    }
                }
                if (i == 1) {
                    int next_result = tmp.result - 1;
                    if (tmp.result == 0) next_result = 9999;
                    if (!ch[next_result]) {
                        String next_command = tmp.command + 'S';
                        ch[next_result] = true;
                        q.offer(new DSLR(next_result, next_command));
                    }
                }
                if (i == 2) {
                    int next_result = (tmp.result % 1000) * 10 + (tmp.result / 1000);
                    if (!ch[next_result]) {
                        String next_command = tmp.command + 'L';
                        ch[next_result] = true;
                        q.offer(new DSLR(next_result, next_command));
                    }
                }
                if (i == 3) {
                    int next_result = (tmp.result % 10) * 1000 + tmp.result / 10;
                    if (!ch[next_result]) {
                        String next_command = tmp.command + 'R';
                        ch[next_result] = true;
                        q.offer(new DSLR(next_result, next_command));
                    }
                }
            }

        }

    }

    public static void main(String[] args) {
        _9019 T = new _9019();
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            ch[a] = true;
            T.BFS(a, b);
        }
        for(String x : list) {
            System.out.println(x);
        }
    }
}