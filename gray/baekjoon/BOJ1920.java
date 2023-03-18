package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1920 {

    /**
     * 1 <= N <= 100_000
     * 1 <= M <= 100_000
     * 18:50 ~ 19:20
     */
    private static int N;
    private static int M;
    private static int[] arr1;
    private static int[] arr2;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        arr1 = new int[N];

        for (int i = 0; i < N; i++) {
            arr1[i] = scanner.nextInt();
        }

        M = scanner.nextInt();
        arr2 = new int[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = scanner.nextInt();
        }

        Arrays.sort(arr1);

        for (int num : arr2) {
            search(num);
        }
    }

    private static void search(int num) {
        int start = 0;
        int end = N - 1;
        boolean flag = false;

        while (start <= end) {
            int mid = (start + end) / 2;

            int value = arr1[mid];

            if (num == value) {
                flag = true;
                break;
            }
            if (num < value) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
