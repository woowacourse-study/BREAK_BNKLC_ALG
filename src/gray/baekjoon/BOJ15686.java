package gray.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ15686 {

    /**
     * 2 ≤ N ≤ 50, 1 ≤ M ≤ 13
     * 0: 빈집
     * 1: 집
     * 2: 치킨집
     * 2302 ~ 00:00
     */

    private static int N;
    private static int M;
    private static int[][] graph;
    private static int answer = Integer.MAX_VALUE;
    private static boolean[] openFlag;
    private static List<Point> houses = new ArrayList<>();
    private static List<Point> chickens = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = scanner.nextInt();
                graph[i][j] = value;
                if (value == 1) {
                    houses.add(new Point(i, j));
                }
                if (value == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }
        openFlag = new boolean[chickens.size()];
        search(0, 0);

        System.out.println(answer);
    }

    private static void search(int index, int count) {
        if (count == M) {
            answer = Math.min(answer, getDistanceSum());
            return;
        }

        for (int i = index; i < chickens.size(); i++) {
            openFlag[i] = true;
            search(i + 1, count + 1);
            openFlag[i] = false;
        }
    }

    private static int getDistanceSum() {
        int sum = 0;

        for (int i = 0; i < houses.size(); i++) {
            int tmp = Integer.MAX_VALUE;

            for (int j = 0; j < chickens.size(); j++) {
                if (openFlag[j]) {
                    int distance = getDistance(houses.get(i), chickens.get(j));
                    tmp = Math.min(tmp, distance);
                }
            }
            sum += tmp;
        }
        return sum;
    }

    private static int getDistance(Point p1, Point p2) {
        return Math.abs(p2.x - p1.x) + Math.abs(p2.y - p1.y);
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
