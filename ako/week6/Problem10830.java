import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10830 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] A = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] answer = powMatrix(A, B);

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] powMatrix(int[][] A, long B) {
        if (B == 1L) {
            return A;
        }

        int[][] seperatedPowMatrix = powMatrix(A, B/2);
        int[][] multiMatrix = multiMatrix(seperatedPowMatrix, seperatedPowMatrix);

        if (B % 2 == 1) {
            multiMatrix = multiMatrix(multiMatrix, A);
        }

        return multiMatrix;
    }

    private static int[][] multiMatrix(int[][] seperatedPow1, int[][] seperatedPow2) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += seperatedPow1[i][k] * seperatedPow2[k][j];
                    result[i][j] %= 1000;
                }
            }
        }
        return result;
    }
}
