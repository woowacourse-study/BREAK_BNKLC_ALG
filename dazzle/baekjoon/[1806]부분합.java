import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        numbers = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            numbers[i] = scan.nextInt();
        }
    }

    static FastReader scan = new FastReader();
    static int N, S;
    static int[] numbers;

    public static void main(String[] args) {
        input();
        pro();
    }

    static void pro() {
        int result = 100001;

        int left = 1;
        int right = 1;
        int sum = numbers[1];

        while (right <= N) {
            if (sum == S) {
                result = Math.min(result, right - left + 1);
                right++;
                sum += numbers[right];
            } else if (sum < S) {
                right++;
                sum += numbers[right];
            } else {
                result = Math.min(result, right - left + 1);
                sum -= numbers[left];
                left++;
            }

            if (left > right) {
                right = left;
                sum += numbers[right];
            }
        }

        if (result == 100001) {
            result = 0;
        }

        System.out.println(result);
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
