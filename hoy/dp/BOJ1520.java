package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1520 {

    static int[][] directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    static int M, N;
    static int[][] map;
    static int[][] cache;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        map = new int[M][N];
        cache = new int[M][N];

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                cache[i][j] = -1;
            }
        }

        System.out.print(dfs(0, 0));
    }

    public static int dfs(int y, int x) {
        if (y == M - 1 && x == N - 1) {
            return 1;
        }

        if (cache[y][x] != -1) {
            return cache[y][x];
        }

        cache[y][x] = 0;

        for (int[] direction : directions) {
            int ny = direction[0] + y;
            int nx = direction[1] + x;

            if (ny >= M || ny < 0 || nx >= N || nx < 0
                || map[y][x] <= map[ny][nx]) {
                continue;
            }

            cache[y][x] += dfs(ny, nx);
        }
        return cache[y][x];
    }
}
