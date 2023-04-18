import java.util.Scanner;

public class BOJ13305 {

    /**
     * 2 ≤ N ≤ 1,000
     * 02:05 ~ 02:30
     */

    private static int N;
    private static long[] DISTANCES;
    private static long[] PRICES;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        DISTANCES = new long[N-1];
        PRICES = new long[N];
        for (int i = 0; i < N - 1; i++) {
            DISTANCES[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            PRICES[i] = scanner.nextInt();
        }

        long answer = 0;
        long minPrice = 0;
        for (int i = 0; i < N - 1; i++) {
            long curPrice = PRICES[i];
            if (i == 0) {
                answer += DISTANCES[i] * curPrice;
                minPrice = curPrice;
                continue;
            }

            if (curPrice <= minPrice) {
                answer += DISTANCES[i] * curPrice;
                minPrice = curPrice;
            } else {
                answer += DISTANCES[i] * minPrice;
            }
        }
        System.out.println(answer);
    }
}
