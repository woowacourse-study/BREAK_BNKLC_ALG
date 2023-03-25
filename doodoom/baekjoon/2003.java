package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        final int[] inputs = Arrays.stream(br.readLine()
                .split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        final int n = inputs[0];
        final int m = inputs[1];

        final int[] numbers = Arrays.stream(br.readLine()
                .split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int count = 0;
        int sum = 0;
        int end = 0;
        for (int start = 0; start < n; start++) {
            while (sum < m && end < n) {
                sum += numbers[end];
                end += 1;
            }
            if (sum == m) {
                count++;
            }
            sum -= numbers[start];
        }

        wr.write(count + "");
        wr.flush();
        wr.close();
    }

}
