package SWEA;


import java.util.Arrays;
import java.util.Scanner;

public class _1208 {


    static int[] arr = new int[100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            int dump = sc.nextInt();
            for (int i = 0; i < 100; i++) {
                arr[i] = sc.nextInt();
            }


            for (int i = 0; i < dump; i++) {
                Arrays.sort(arr);
                arr[0]++;
                arr[99]--;
                if ((arr[99] - arr[0]) == 1) {
                    break;
                }
                if ((arr[99] - arr[0]) == 0) {
                    break;
                }
            }
            Arrays.sort(arr);
            int result = arr[99] - arr[0];
            System.out.println("#" + t + " " + result);
        }
    }
}
