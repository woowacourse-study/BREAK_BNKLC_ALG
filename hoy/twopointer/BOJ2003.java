package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2003 {
    static int N, M;
    static int result = 0;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        A = new int[N];
        input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        int left = 0;
        int right = 0;
        int sum = 0;

        while (right <= N) {
            if (sum >= M) {
                sum -= A[left++];
            } else if (right == N) {
                break;
            } else {
                sum += A[right++];
            }

            if (sum == M) {
                result++;
            }
        }

        System.out.print(result);
    }
}
