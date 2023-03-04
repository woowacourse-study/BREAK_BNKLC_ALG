package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
        new OutputStreamWriter(System.out));

    static int n, m;
    static int result = Integer.MAX_VALUE;
    static int[][] board;
    static List<Point> chickens = new ArrayList<>(); //치킨집 위치를 저장하는 리스트
    static List<Point> houses = new ArrayList<>();
    static List<Point> select = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        board = new int[n][];
        // 치킨, 집 저장
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    houses.add(new Point(i, j));
                } else if (board[i][j] == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }

        dfs(0);
        wr.write(result + "");
        wr.flush();
        wr.close();
    }

    private static void dfs(final int idx) {
        if (select.size() == m) {
            int total = 0;
            for (Point house : houses) {
                int distance = Integer.MAX_VALUE;
                for (Point point : select) {
                    distance = Math.min(distance, house.distance(point));
                }
                total += distance;
            }
            result = Math.min(result, total);
            return;
        }

        if (idx == chickens.size()) {
            return;
        }

        select.add(chickens.get(idx));
        dfs(idx + 1);
        select.remove(select.size() - 1);
        dfs(idx + 1);
    }


    static class Point {

        private final int x;
        private final int y;

        Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        int distance(final Point point) {
            return Math.abs(x - point.x) + Math.abs(y - point.y);
        }
    }
}
