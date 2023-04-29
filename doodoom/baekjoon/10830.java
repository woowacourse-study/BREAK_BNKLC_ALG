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
    private static final int MOD = 1000;
    private static final String SPACE = " ";
    private static int N;
    private static long[][] given;

    public static void main(String[] args) throws IOException {
        final String[] nb = br.readLine().split(SPACE);
        N = Integer.parseInt(nb[0]);
        long b = Long.parseLong(nb[1]);
        given = new long[N][N];

        for (int i = 0; i < N; i++) {
            given[i] = Arrays.stream(br.readLine().split(SPACE))
                .mapToLong(Long::parseLong)
                .map(num -> num % MOD)
                .toArray();
        }

        long[][] result = pow(given, b);

        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(SPACE);
            }
            if (i == N - 1) {
                continue;
            }
            sb.append("\n");
        }

        wr.write(sb.toString());
        wr.flush();
        wr.close();
        br.close();
    }

    private static long[][] pow(long[][] arr, long square) {
        if (square == 1) {
            return arr;
        }

        long[][] ret = pow(arr, square / 2);
        ret = multiply(ret, ret);

        if (square % 2 == 1L) {
            return multiply(ret, given);
        }
        return ret;
    }

    // o1과 o2 행렬을 곱해주는 메소드
    public static long[][] multiply(long[][] o1, long[][] o2) {
        long[][] ret = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= MOD;    // 행렬 원소 연산이 끝나면 MOD로 나머지연산
                }
            }
        }
        return ret;
    }
}
