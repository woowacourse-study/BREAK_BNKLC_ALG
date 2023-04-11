import java.util.Scanner;

public class BOJ3020 {

    /**
     * 2 ≤ N ≤ 200,000
     * 2 ≤ H ≤ 500,000
     * 풀이 참고
     */

    private static int N;
    private static int H;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        H = scanner.nextInt();

        int[] flour = new int[H + 1];
        int[] ceil = new int[H + 1];

        for (int i = 0; i < H + 1; i++) {
            flour[i] = 0;
            ceil[i] = 0;
        }


        for (int i = 1; i <= N; i++) {
            int position = scanner.nextInt();
            if (i % 2 == 0) {
                flour[position]++;
            } else {
                ceil[position]++;
            }
        }

        // H = 7
        for (int i = H - 1; i > 0; i--) {
            ceil[i] = ceil[i] + ceil[i + 1];
            flour[i] = flour[i] + flour[i + 1];
        }

        int[] crush = new int[H + 1];
        int min = N + 1;
        for (int i = 1; i < H + 1; i++) {
            crush[i] = ceil[i] + flour[H - i + 1];
            min = Math.min(min, crush[i]);
        }

        int count = 0;
        for (int i = 1; i <= H; i++) {
            if (crush[i] == min) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }
}
