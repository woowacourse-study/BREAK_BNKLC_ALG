import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ15686 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] map = new int[N][N];

        List<Position> chickensHouses = new ArrayList<>();
        List<Position> houses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    houses.add(new Position(i, j));
                    continue;
                }
                if (map[i][j] == 2) {
                    chickensHouses.add(new Position(i, j));
                }
            }
        }
        int result = Integer.MAX_VALUE;

        for (int bit = 1; bit < 1 << chickensHouses.size(); bit++) {
            int bitCount = 0;
            for (int i = 1; i < 1 << chickensHouses.size(); i *= 2) {
                if ((bit & i) != 0) {
                    bitCount++;
                }
            }
            if (bitCount > M) {
                continue;
            }

            int[] distanceArr = new int[houses.size()];
            for (int idx = 0; idx < chickensHouses.size(); idx++) {
                if ((bit & (1 << idx)) >= 1) {
                    Position position = chickensHouses.get(idx);
                    for (int i = 0; i < houses.size(); i++) {
                        int distance = position.getDistance(houses.get(i));
                        if (distanceArr[i] == 0) {
                            distanceArr[i] = distance;
                        }
                        distanceArr[i] = Math.min(distanceArr[i], distance);
                    }
                }
            }
            result = Math.min(result, Arrays.stream(distanceArr).sum());
        }
        System.out.print(result);

    }

    static class Position {

        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDistance(Position o) {
            return Math.abs(o.x - this.x) + Math.abs(o.y - this.y);
        }
    }
}
