import java.util.Scanner;

public class BOJ10830 {

    /**
     * 2 <= N <= 5 1 <= B <= 100,000,000,000
     */
    private static int N;
    private static long B;
    private static int[][] mat;

    private static final int MOD = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        B = scanner.nextInt();

        mat = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                mat[i][j] = scanner.nextInt() % MOD;
            }
        }

        int[][] result = pow(mat, B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] pow(int[][] A, long exp) {

        // 지수가 1일 땐 A를 return
        if (exp == 1L) {
            return A;
        }

        // 지수를 절반으로 분할하여 재귀호출
        int[][] ret = pow(A, exp / 2);

        // 하위 재귀에서 얻은 행렬을 제곱
        ret = multiply(ret, ret);

        // 만약 지수가 홀수라면 마지막에  A^1 을 곱한다
        if (exp % 2 == 1L) {
            ret = multiply(ret, mat);
        }

        return ret;
    }

    private static int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] ret = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    ret[i][j] += (mat1[i][k] * mat2[k][j]);
                    ret[i][j] = ret[i][j] % MOD;
                }
            }
        }
        return ret;
    }
}
