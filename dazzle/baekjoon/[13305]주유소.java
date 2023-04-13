import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void input() {
        N = scan.nextInt();
        distances = new int[N - 1];
        costs = new int[N];
        for (int i = 0; i < N - 1; i++) {
            distances[i] = scan.nextInt();
        }
        for (int i = 0; i < N; i++) {
            costs[i] = scan.nextInt();
        }
    }

    static FastReader scan = new FastReader();
    static int N;
    static int[] distances, costs;

    public static void main(String[] args) {
        input();
        pro();
    }

    static void pro() {
        long totalCost = 0;

        for (int i = 0; i < N - 1; i++) {
            int index = searchLowCostIndex(i);
            if (index == -1) {
                totalCost += sum(i, N - 1, costs[i]);
                break;
            } else {
                totalCost += sum(i, index, costs[i]);
                i += (index - i - 1);
            }
        }

        System.out.println(totalCost);
    }

    static int searchLowCostIndex(int target) {
        for (int i = target + 1; i < N - 1; i++) {
            if (costs[i] < costs[target]) {
                return i;
            }
        }
        return -1;
    }

    static long sum(int from, int to, int cost) {
        long result = 0;
        for (int i = from; i < to; i++) {
            result += (long) cost * distances[i];
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
