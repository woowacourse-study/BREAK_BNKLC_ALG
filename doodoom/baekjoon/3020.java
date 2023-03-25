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

    static int[] bottom, top, result;

    public static void main(String[] args) throws IOException {
        final String[] input = br.readLine().split(" ");
        final int n = Integer.parseInt(input[0]);
        final int h = Integer.parseInt(input[1]);

        int count = n / 2;
        top = new int[count];
        bottom = new int[count];
        for (int i = 0; i < count; i++) {
            bottom[i] = Integer.parseInt(br.readLine());
            top[i] = Integer.parseInt(br.readLine());
        }
        result = new int[h];

        Arrays.sort(bottom);
        Arrays.sort(top);

        for (int i = 0; i < h; i++) {
            int bottomIndex = countLower(bottom, i + 1);
            int topIndex = countLower(top, h - i);
            result[i] = (top.length - (topIndex + 1)) + (bottom.length - (bottomIndex + 1));
        }

        int min = Arrays.stream(result).min().getAsInt();
        long dup = Arrays.stream(result)
            .filter(x -> x == min)
            .count();

        wr.write(min + " " + dup);
        wr.flush();
        wr.close();
    }

    private static int countLower(final int[] arr, final int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }


}
