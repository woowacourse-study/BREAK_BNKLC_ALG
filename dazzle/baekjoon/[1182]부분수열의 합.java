import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }
    }

    static FastReader scan = new FastReader();
    static int N, S;
    static int[] nums;
    static int answer = 0;

    public static void main(String[] args) {
        input();
        pro();
    }

    static void pro() {
        sum(1, 0);
        if (S == 0) {
            answer--;
        }
        System.out.println(answer);
    }

    static void sum(final int position, final int sum) {
        if (position == N + 1) {
            if (sum == S) {
                answer++;
            }
        } else {
            sum(position + 1, sum + nums[position]);
            sum(position + 1, sum);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
