import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static int N, answer;
    static int H = 0;
    static int[][] area, checked;
    static int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        N = scan.nextInt();
        area = new int[N][N];
        checked = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                area[i][j] = scan.nextInt();
                if (area[i][j] > H) {
                    H = area[i][j];
                }
            }
        }
    }

    static void pro() {
        for (int i = 0; i <= H; i++) {
            int result = 0;
            checked = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (checked[j][k] == 1 || area[j][k] <= i) {
                        continue;
                    }
                    bfs(j, k, i);
                    result += 1;
                }
            }
            if (result > answer) {
                answer = result;
            }
        }
        System.out.println(answer);
    }

    static void bfs(int y, int x, int h) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(y);
        queue.offer(x);

        while (!queue.isEmpty()) {
            int posY = queue.poll();
            int posX = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = posY + direction[i][0];
                int nextX = posX + direction[i][1];

                if ((0 <= nextY && nextY < N) && (0 <= nextX && nextX < N)) {
                    if (area[nextY][nextX] > h && checked[nextY][nextX] == 0) {
                        queue.add(nextY);
                        queue.add(nextX);
                        checked[nextY][nextX] = 1;
                    }
                }
            }
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
