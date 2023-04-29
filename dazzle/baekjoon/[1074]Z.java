import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static int N, r, c, count;

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        N = scan.nextInt();
        r = scan.nextInt();
        c = scan.nextInt();
    }

    static void pro() {
        recursionForQuad((int) Math.pow(2, N), r, c);
        System.out.println(count);
    }

    static void recursionForQuad(int size, int row, int column) {
        if (size == 1) {
            return;
        }

        int half = size / 2;
        if (row < half && column < half) {
            recursionForQuad(half, row, column);
        } else if (row < half && column < half * 2) {
            count += half * half;
            recursionForQuad(half, row, column - half);
        } else if (row < half * 2 && column < half) {
            count += half * half * 2;
            recursionForQuad(half, row - half, column);
        } else if (row < half * 2 && column < half * 2) {
            count += half * half * 3;
            recursionForQuad(half, row - half, column - half);
        }
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
