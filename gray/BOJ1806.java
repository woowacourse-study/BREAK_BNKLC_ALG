import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ1806 {

    /**
     * 10 ≤ N < 100,000
     * 0 < S ≤ 100,000,000
     */

    private static int N;
    private static int M;
    private static int[] numbers;

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        N = scanner.nextInt();
        M = scanner.nextInt();
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        int start = 0;
        int end = 0;
        int sum = 0;

        List<Integer> distances = new ArrayList<>();
        while (start <= N) {
            if (sum >= M) {
                distances.add(end - start);
                sum -= numbers[start];
                start++;

            } else {
                if (end == N) {
                    break;
                }
                sum += numbers[end];
                end++;
            }
        }

        if (distances.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(distances));
        }
    }
}
