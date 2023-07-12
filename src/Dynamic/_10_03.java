package Dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Cuboid implements Comparable<Cuboid>{
    public int bottom_wide, height, weight;
    Cuboid(int bottom_wide, int height, int weight) {
        this.bottom_wide = bottom_wide;
        this.height = height;
        this.weight = weight;
    }
    @Override
    public int compareTo(Cuboid o) {
        return o.bottom_wide - this.bottom_wide; //내림차순
    }
}
public class _10_03 {
    static int[] dy;
    static ArrayList<Cuboid> arr;
    public int solution(ArrayList<Cuboid> arr) {
        int answer;
        Collections.sort(arr);
        dy[0] = arr.get(0).height;
        answer = dy[0];
        for (int i = 1; i < arr.size(); i++) {
            int max_h = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(j).weight > arr.get(i).weight && dy[j] > max_h) {
                    max_h = dy[j];
                }
            }
            dy[i] = max_h + arr.get(i).height;
            answer = Math.max(answer, dy[i]);
        }
        return answer;






    }

    public static void main(String[] args) {
        _10_03 T = new _10_03();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n];
        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Cuboid(a,b,c));
        }
        System.out.println(T.solution(arr));

    }
}
