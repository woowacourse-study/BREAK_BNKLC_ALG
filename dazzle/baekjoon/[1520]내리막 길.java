import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        map = new int[N + 2][M + 2];
        route = new int[N + 2][M + 2];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i <= N; i++) {
            Arrays.fill(route[i], -1);
        }
    }

    static FastReader scan = new FastReader();
    static int N, M;
    static int[][] map, route;
    static int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        input();
        pro();
    }

    static void pro() {
        System.out.println(dfs(1, 1));
    }

    static int dfs(int y, int x) {
        if (x == M && y == N) {
            return 1;
        }

        if (route[y][x] == -1) {
            route[y][x] = 0;
            for (int i = 0; i < 4; i++) {
                int nextY = y + directions[i][0];
                int nextX = x + directions[i][1];
                if (map[y][x] != 0 && map[y][x] > map[nextY][nextX]) {
                    route[y][x] += dfs(nextY, nextX);
                }
            }
        }

        return route[y][x];
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
