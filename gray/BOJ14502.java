import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ14502 {

    /**
     * 3 <= N, M <= 8
     * 0: 빈칸, 1: 벽, 2: 바이러스
     * 21:45 ~ 22:41
     */

    private static int N;
    private static int M;
    private static int[][] board;
    private static int[][] boardSnapshot;
    private static int answer;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        board = new int[N][M];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = scanner.nextInt();
                if (board[i][j] == 0) {
                }
            }
        }
        dfs( 0);

        System.out.println(answer);
    }

    private static void dfs(int count) {
        if (count == 3) {
            boardSnapshot = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    boardSnapshot[i][j] = board[i][j];
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (boardSnapshot[i][j] == 2) {
                        attack(new Position(i, j));
                    }
                }
            }
            answer = Math.max(answer, findSafeArea());
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    dfs(count + 1);
                    board[i][j] = 0;
                }
            }
        }
    }

    private static void attack(Position position) {
        Queue<Position> positions = new ArrayDeque<>();
        positions.add(position);

        while (!positions.isEmpty()) {
            Position current = positions.poll();
            int currentX = current.x;
            int currentY = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < M)) {
                    if (boardSnapshot[nx][ny] == 0) {
                        positions.add(new Position(nx, ny));
                        boardSnapshot[nx][ny] = 2;
                    }
                }
            }
        }
    }

    private static int findSafeArea() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (boardSnapshot[i][j] == 0) {
                    count ++;
                }
            }
        }
        return count;
    }

    static class Position {
        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
