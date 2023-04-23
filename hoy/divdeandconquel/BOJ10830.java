package divdeandconquel;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10830 {
    static int N;
    static long B;
    static final int MOD = 1000;
    static int[][] origin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String[] inputs = br.readLine().split(" ");

        N = parseInt(inputs[0]);
        B = Long.parseLong(inputs[1]);

        origin = new int[N][N];

        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                origin[i][j] = parseInt(inputs[j]) % MOD;
            }
        }

        int[][] result = pow(origin, B);
        print(result);
    }

    public static int[][] pow(int[][] matrix, long exp) {
        if (exp == 1L) {
            return matrix;
        }

        int[][] half = pow(matrix, exp / 2);
        int[][] result = multiply(half, half);

        if (exp % 2 == 1L) {
            return multiply(result, origin);
        }

        return result;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }

    public static void print(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString().strip());
    }
}
