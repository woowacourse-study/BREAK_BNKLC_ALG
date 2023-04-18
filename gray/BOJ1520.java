import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1520 {

    /**
     * 3:15 ~ 4:16
     */

    private static int M;
    private static int N;
    private static int[][] board;

    private static int dx[] = {-1, 1, 0, 0};
    private static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        M = scanner.nextInt();
        N = scanner.nextInt();
        board = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        int answer = search(0, 0);
        System.out.println(answer);
    }

    private static int search(int x, int y) {
        Position initPosition = new Position(0, 0, board[x][y]);
        PriorityQueue<Position> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(initPosition);

        int[][] dp = new int[M][N];
        dp[x][y] = 1;
        while (!maxHeap.isEmpty()) {
            Position position = maxHeap.poll();
            int currentX = position.getX();
            int currentY = position.getY();

            if (currentX == M - 1 && currentY == N - 1) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                if ((0 <= nx && nx < M) && (0 <= ny && ny < N)) {
                    int nextValue = board[nx][ny];
                    int currentValue = position.getValue();
                    if (nextValue < currentValue) {
                        if (dp[nx][ny] == 0) {
                            maxHeap.add(new Position(nx, ny, nextValue));
                        }
                        dp[nx][ny] += dp[currentX][currentY];
                    }
                }
            }
        }
        return dp[M - 1][N - 1];
    }

    static class Position implements Comparable<Position> {

        private final int x;
        private final int y;
        private final int value;

        public Position(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getValue() {
            return value;
        }

        @Override
        public int compareTo(Position o) {
            return this.value - o.value;
        }
    }
}
