import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                int block = scan.nextInt();
                if (block == 1) {
                    house.add(new Point(x, y));
                }
                if (block == 2) {
                    chicken.add(new Point(x, y));
                }
            }
        }
    }

    static FastReader scan = new FastReader();
    static int N, M;
    static List<Point> house = new ArrayList<>();
    static List<Point> chicken = new ArrayList<>();
    static List<Point> save = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        input();
        pro();
    }

    static void pro() {
        chickenDistance(0);
        System.out.println(answer);
    }

    static void chickenDistance(final int index) {
        if (save.size() == M) {
            final int result = calculateDistance();
            answer = Math.min(answer, result);
            return;
        }

        if (index == chicken.size()) {
            return;
        }

        save.add(chicken.get(index));
        chickenDistance(index + 1);
        save.remove(save.size() - 1);
        chickenDistance(index + 1);
    }

    static int calculateDistance() {
        int result = 0;
        for (final Point house : house) {
            int distance = Integer.MAX_VALUE;
            for (final Point save : save) {
                distance = Math.min(distance, house.getDistance(save));
            }
            result += distance;
        }
        return result;
    }

    static class Point {

        public int x;
        public int y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public int getDistance(final Point point) {
            return Math.abs(x - point.x) + Math.abs(y - point.y);
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
