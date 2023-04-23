import java.util.Scanner;

public class BOJ1074 {

    /**
     * 1 <= N <= 15
     * 0 <= r,c < 2^N
     * 05:30 ~ 06:11
     */

    private static int N;
    private static int r;
    private static int c;
    private static int cnt = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        r = scanner.nextInt();
        c = scanner.nextInt();

        divide((int) Math.pow(2, N), 0, 0);
    }

    private static void divide(int size, int start_row, int start_col) {
        if (start_row == r && start_col == c) {
            System.out.println(cnt);
            return;
        }
        if ((start_row <= r && r < start_row + size) && (start_col <= c && c < start_col + size)) {
            int nextSize = size / 2;
            divide(nextSize, start_row, start_col);
            divide(nextSize, start_row, start_col + nextSize);
            divide(nextSize, start_row + nextSize, start_col);
            divide(nextSize, start_row + nextSize, start_col + nextSize);
        } else {
            cnt += (int) Math.pow(size, 2);
        }
    }

}
