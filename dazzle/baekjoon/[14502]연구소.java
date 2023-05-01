import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static int N, M, answer;
    static int[][] area, visited;
    static int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static List<Point> points = new ArrayList<>();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        area = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                area[i][j] = scan.nextInt();
            }
        }
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] == 0) {
                    points.add(new Point(j, i));
                }
            }
        }
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int index, int count) {
        if (count == 3) {
            visited = new int[N][M];
            bfs();
            return;
        }

        if (index > points.size() - 1) {
            return;
        }

        Point point = points.get(index);

        area[point.y][point.x] = 1;
        dfs(index + 1, count + 1);

        area[point.y][point.x] = 0;
        dfs(index + 1, count);
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] == 2) {
                    queue.offer(new Point(j, i));
                    visited[i][j] = 1;
                }
            }
        }

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = point.y + direction[i][0];
                int nextX = point.x + direction[i][1];

                if ((0 <= nextY && nextY < N) && (0 <= nextX && nextX < M)) {
                    if (area[nextY][nextX] == 0 && visited[nextY][nextX] == 0) {
                        queue.offer(new Point(nextX, nextY));
                        visited[nextY][nextX] = 1;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] == 0 && visited[i][j] == 0) {
                    result += 1;
                }
            }
        }

        if (result > answer) {
            answer = result;
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
