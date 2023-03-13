package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
        new OutputStreamWriter(System.out));
    private static final int MAX_M = 5_000;

    public static void main(String[] args) throws IOException {
        final int n = Integer.parseInt(br.readLine());
        final int[] craneInput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int m = Integer.parseInt(br.readLine());
        final int[] boxesInput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        final List<Integer> cranes = Arrays.stream(craneInput)
            .boxed()
            .collect(Collectors.toList());
        final List<Integer> boxes = Arrays.stream(boxesInput)
            .boxed()
            .collect(Collectors.toList());

        Collections.sort(cranes, Collections.reverseOrder());
        Collections.sort(boxes, Collections.reverseOrder());

        if (cranes.get(0) < boxes.get(0)) {
            wr.write(-1 + "");
            wr.flush();
            wr.close();
            return;
        }

        int time = 0;
        while (!boxes.isEmpty()) {
            int boxesIndex = 0;
            for (int index = 0; index < cranes.size(); index++) {
                if (boxesIndex == boxes.size()) {
                    break;
                } else if (cranes.get(index) >= boxes.get(boxesIndex)) {
                    boxes.remove(boxesIndex);
                } else {
                    boxesIndex++;
                    index--;
                }
            }
            time++;
        }

        wr.write(time + "");
        wr.flush();
        wr.close();
    }

}
