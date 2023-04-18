package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final String SPACE = " ";
    static BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        final int n = Integer.parseInt(br.readLine());
        final long[] distances = Arrays.stream(br.readLine().split(SPACE))
            .mapToLong(Long::parseLong)
            .toArray();
        final long[] prices = Arrays.stream(br.readLine().split(SPACE))
            .mapToLong(Long::parseLong)
            .toArray();
        ;

        long result = prices[0] * distances[0];
        long minPrice = prices[0];

        for (int i = 1; i < n - 1; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
            result += (minPrice * distances[i]);
        }

        wr.write(String.valueOf(result));
        wr.flush();
        wr.close();
        br.close();
    }

}
