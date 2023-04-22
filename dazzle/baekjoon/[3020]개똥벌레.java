import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static void input() {
        N = scan.nextInt();
        H = scan.nextInt();
        int count = N / 2;
        top = new int[count];
        bottom = new int[count];
        for (int i = 0; i < count; i++) {
            bottom[i] = scan.nextInt();
            top[i] = scan.nextInt();
        }
        result = new int[H];
    }

    static FastReader scan = new FastReader();
    static int N, H;
    static int[] top, bottom, result;

    public static void main(String[] args) {
        input();
        pro();
    }

    static void pro() {
        Arrays.sort(top);
        Arrays.sort(bottom);

        for (int i = 0; i < H; i++) {
            int bottomIndex = getLowerHeightIndex(bottom, i + 1);
            int topIndex = getLowerHeightIndex(top, H - i);
            result[i] = (top.length - (topIndex + 1)) + (bottom.length - (bottomIndex + 1));
        }

        int min = Arrays.stream(result)
                .min().getAsInt();

        long count = Arrays.stream(result)
                .filter(i -> i == min)
                .count();

        System.out.println(min + " " + count);
    }

    static int getLowerHeightIndex(int[] target, int height) {
        int left = 0;
        int right = target.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target[mid] < height) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
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
