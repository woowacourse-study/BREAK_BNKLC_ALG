package baekjoon;

import java.util.Scanner;

public class BOJ1182 {

    /**
     * Input: N, S
     * 1 <= N <= 20
     * -1_000_000 <= |S| <=  1_000_000
     * time: 23:10 ~ 23:44
     * @param args
     */

    private static int N;
    private static int S;
    private static int[] array;
    private static int answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        S = scanner.nextInt();
        array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }

        search(0, 0);

        if (S == 0) {
            answer--;
        }

        System.out.println(answer);
    }

    private static void search(int index, int sum) {
        if (index == N) {
            if (sum == S) {
                answer++;
            }
            return;
        }

        search(index + 1, sum + array[index]);
        search(index + 1, sum);
    }
}
