import java.util.Scanner;

public class BOJ2003 {

    /**
     * 1 <= N <= 10_000
     * 1 <= M <= 300_000_000
     */

    private static int N;
    private static int M;
    private static int[] number;

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        N = scanner.nextInt();
        M = scanner.nextInt();
        number = new int[N];

        for (int i = 0; i < N; i++) {
            number[i] = scanner.nextInt();
        }


        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;
        while (end <= N) {
            if (sum >= M) {
                sum -= number[start];
                start++;
            } else if (end == N) {
                break;
            } else {
                sum += number[end];
                end++;
            }

            if (sum == M) {
                count++;
            }
        }
        System.out.println(count);
    }
}
