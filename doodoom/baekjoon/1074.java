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
    private static int N;
    private static int r;
    private static int c;

    public static void main(String[] args) throws IOException {
        final int[] nrc = Arrays.stream(br.readLine().split(SPACE))
            .mapToInt(Integer::parseInt)
            .toArray();
        N = nrc[0];
        r = nrc[1]; // 행
        c = nrc[2]; // 열

        // 사각형을 4개로 나누고 어디 위치인지 확인 -> 재귀로 최종 위치까지 확인
        wr.write(String.valueOf(recursion(N, new int[]{0, 0}, 0)));
        wr.flush();
        wr.close();
        br.close();
    }

    private static int recursion(final int n, final int[] start, final int value) {
        if (n == 0) {
            return value;
        }
        final int halfRow = (int) (start[0] + (start[0] + (Math.pow(2, n) - 1))) / 2;
        final int halfCol = (int) (start[1] + (start[1] + (Math.pow(2, n) - 1))) / 2;

        // 1 사분면
        if (halfRow >= r && halfCol < c) {
            return recursion(n - 1, new int[]{start[0], halfCol + 1},
                (int) (value + Math.pow(Math.pow(2, n - 1), 2)));
        }

        // 2 사분면
        if (halfRow >= r && halfCol >= c) {
            return recursion(n - 1, start, value);
        }

        // 3 사분면
        if (halfRow < r && halfCol >= c) {
            return recursion(n - 1, new int[]{halfRow + 1, start[1]},
                (int) (value + Math.pow(Math.pow(2, n - 1), 2) * 2));
        }

        // 4 사분면
        if (halfRow < r && halfCol < c) {
            return recursion(n - 1, new int[]{halfRow + 1, halfCol + 1},
                (int) (value + Math.pow(Math.pow(2, n - 1), 2) * 3));
        }

        return 1;
    }

}
