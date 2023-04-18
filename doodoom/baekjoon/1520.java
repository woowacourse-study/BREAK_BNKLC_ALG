package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter wr = new BufferedWriter(
        new OutputStreamWriter(System.out));
    private static final String SPACE = " ";
    private static int m;
    private static int n;
    private static final int[] rowDiff = {-1, 0, 1, 0};
    private static final int[] colDiff = {0, 1, 0, -1};
    private static int[][] board;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        final int[] mn = Arrays.stream(br.readLine().split(SPACE))
            .mapToInt(Integer::parseInt)
            .toArray();
        m = mn[0];
        n = mn[1];
        board = new int[m][];
        for (int i = 0; i < m; i++) {
            board[i] = Arrays.stream(br.readLine().split(SPACE))
                .mapToInt(Integer::parseInt)
                .toArray();
        }
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        wr.write(String.valueOf(dfs(0, 0)));
        wr.flush();
        wr.close();
        br.close();
    }

    private static int dfs(final int col, final int row) {
        if (col == n - 1 && row == m - 1) {
            return 1;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        dp[row][col] = 0;
        for (int i = 0; i < 4; i++) {
            int r = row + rowDiff[i];
            int c = col + colDiff[i];

            if (r < 0 || c < 0 || r > m - 1 || c > n - 1) {
                continue;
            }

            if (board[r][c] < board[row][col]) {
                dp[row][col] += dfs(c, r);
            }
        }

        return dp[row][col];
    }
}
