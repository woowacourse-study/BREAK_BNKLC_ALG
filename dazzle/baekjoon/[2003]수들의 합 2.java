import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        numbers = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            numbers[i] = scan.nextInt();
        }
    }

    static FastReader scan = new FastReader();
    static int N, M;
    static int[] numbers;

    public static void main(String[] args) {
        input();
        pro();
    }

    static void pro() {
        int left = 1;
        int right = 1;

        int result = 0;

        while (right <= N) {
            int sum = sum(left, right);

            if (sum == M) {
                result++;
                left++;
            } else if (sum < M) {
                right++;
            } else {
                left++;
            }

            if (left > right) {
                right = left;
            }
        }

        System.out.println(result);
    }

    static int sum(int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++) {
            result += numbers[i];
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
    }
}
