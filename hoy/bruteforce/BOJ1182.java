import java.util.Scanner;

public class BOJ1182 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int S = scanner.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int result = 0;

        for (int bit = 1; bit < 1 << N; bit++) {
            int sum = 0;
            for (int idx = 0; idx < N; idx++) {
                if ((bit & (1 << idx)) >= 1) {
                    sum += arr[idx];
                }
            }
            if (sum == S) {
                result++;
            }
        }
        System.out.print(result);
    }
}
