import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static int MOD = 1000;
    static int N;
    static long B;
    static int[][] matrix;

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        N = scan.nextInt();
        B = scan.nextLong();
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scan.nextInt() % MOD;
            }
        }
    }

    static void pro() {
        int[][] result = recursionCalculate(B);

        StringJoiner view = new StringJoiner("\n");
        for (int i = 0; i < N; i++) {
            StringJoiner line = new StringJoiner(" ");
            for (int j = 0; j < N; j++) {
                line.add(String.valueOf(result[i][j]));
            }
            view.add(line.toString());
        }

        System.out.println(view);
    }

    static int[][] recursionCalculate(long expo) {
        if (expo == 1) {
            return matrix;
        }

        int[][] result = recursionCalculate(expo / 2);

        int[][] calculateResult = multiply(result, result);

        if (expo % 2 == 1) {
            calculateResult = multiply(calculateResult, matrix);
        }

        return calculateResult;
    }

    static int[][] multiply(int[][] firstMatrix, int[][] secondMatrix) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {

                    result[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                    result[i][j] %= MOD;
                }
            }
        }

        return result;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
