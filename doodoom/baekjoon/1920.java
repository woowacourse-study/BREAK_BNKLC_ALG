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

    static int[] arr;

    public static void main(String[] args) throws IOException {
        final int n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        final int m = Integer.parseInt(br.readLine());
        final int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int number : numbers) {
            wr.write(contains(number) + "\n");
        }

        wr.flush();
        wr.close();
    }

    public static int contains(final int number) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            final int mid = (low + high) / 2;
            if (arr[mid] == number) {
                return 1;
            }
            if (arr[mid] > number) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }

}
