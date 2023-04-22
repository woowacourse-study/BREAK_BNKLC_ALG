import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static void input() {
        N = scan.nextInt();
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scan.nextInt();
        }
        M = scan.nextInt();
        targets = new int[M];
        for (int i = 0; i < M; i++) {
            targets[i] = scan.nextInt();
        }
    }

    static FastReader scan = new FastReader();
    static int N, M;
    static int[] numbers, targets;

    public static void main(String[] args) {
        input();
        pro();
    }

    static void pro() {
        Arrays.sort(numbers);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            if (isExist(targets[i])) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    static boolean isExist(int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (numbers[mid] == target) {
                return true;
            }

            if (numbers[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
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
