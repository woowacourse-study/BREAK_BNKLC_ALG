package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1806 {

    static int N, S;
    static int[] A;

    static int length = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        A = new int[N];
        input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        int left = 0;
        int right = 0;
        int sum = 0;

        while (true) {
            if (sum >= S) {
                sum -= A[left++];
            } else if (right == N) {
                break;
            } else {
                sum += A[right++];
            }

            if (sum >= S) {
                length = Math.min(length, right - left);
            }
        }
        if (length == Integer.MAX_VALUE) {
            System.out.println(0);
        }else{
            System.out.print(length);
        }
    }
}
