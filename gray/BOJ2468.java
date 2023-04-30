import java.util.ArrayDeque;
import java.util.Scanner;

public class BOJ2468 {

    /**
     * 21:00 ~ 21:35
     */

    private static int N;
    private static int[][] board;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        board = new int[N][N];

        int MAX = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = scanner.nextInt();
                MAX = Math.max(board[i][j], MAX);
            }
        }

        int answer = 0;
        for (int water = 0; water <= MAX; water++) {
            int[][] cmp = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] > water) {
                        cmp[i][j] = 1;
                    }
                }
            }
            answer = Math.max(answer, search(cmp));
        }
        System.out.println(answer);
    }

    private static int search(int[][] cmp) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cmp[i][j] == 1) {
                    bfs(cmp, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(int[][] cmp, int x, int y) {
        ArrayDeque<Position> q = new ArrayDeque<>();

        q.add(new Position(x, y));
        cmp[x][y] = 0;
        while (!q.isEmpty()) {
            Position position = q.poll();
            int currentX = position.getX();
            int currentY = position.getY();

            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < N)) {
                    if (cmp[nx][ny] == 1) {
                        q.add(new Position(nx, ny));
                        cmp[nx][ny] = 0;
                    }
                }
            }
        }
    }

    static class Position {
        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
