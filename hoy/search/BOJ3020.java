package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3020 {

    /**
     * 개똥벌레
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] up = new int[H + 1];
        int[] down = new int[H + 1];

        for (int i = 1; i <= N; i++) {
            int length = Integer.parseInt(br.readLine());
            if (i % 2 != 0) {
                up[length]++;
                continue;
            }
            down[H - length + 1]++;
        }

        int[] upSum = new int[H + 1];
        upSum[1] = Arrays.stream(up).sum();
        for (int i = 2; i <= H; i++) {
            upSum[i] = upSum[i - 1] - up[i - 1];
        }
        int[] downSum = new int[H + 1];
        downSum[H] = Arrays.stream(down).sum();
        for (int i = H-1; i >= 1; i--) {
            downSum[i] = downSum[i + 1] - down[i + 1];
        }

        int[] sum = new int[H + 1];
        sum[0] = Integer.MAX_VALUE;
        for (int i = 1; i <= H; i++) {
            sum[i] = upSum[i] + downSum[i];
        }

        int min = Arrays.stream(sum).min().getAsInt();
        long minCount = Arrays.stream(sum)
            .filter(number -> number == min)
            .count();

        System.out.print(min + " " + minCount);
    }
}
