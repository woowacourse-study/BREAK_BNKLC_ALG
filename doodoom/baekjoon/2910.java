package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Main {

    static BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        final int[] nc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int n = nc[0];
        final int c = nc[1];

        final int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        final Map<Integer, Integer> map = new LinkedHashMap<>();
        for (Integer element : input) {
            if (map.containsKey(element)) {
                map.replace(element, map.get(element) + 1);
            } else {
                map.put(element, 1);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        list.sort(
            (a, b) -> Integer.compare(map.get(b), map.get(a))
        );

        StringJoiner stringJoiner = new StringJoiner(" ");
        for (Integer element : list) {
            for (int i = 0; i < map.get(element); i++) {
                stringJoiner.add(element + "");
            }
        }

        wr.write(stringJoiner.toString());
        wr.flush();
        wr.close();
    }

}
