import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2468 {

    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};
    static Queue<int[]> queue = new LinkedList<>();
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                max = Math.max(height, max);
                map[i][j] = height;
            }
        }
        for (int i = 0; i < max; i++) {
            findSafeArea(i);
        }

        System.out.println(answer);
    }

    private static void findSafeArea(int rainHeight) {
        int cnt = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false && map[i][j] > rainHeight) {
                    cnt++;
                    bfs(i, j, rainHeight);
                }
            }
        }
        answer = Math.max(answer, cnt);
    }

    private static void bfs(int x, int y, int rainHeight) {
        queue.add(new int[] {x, y});
        while(!queue.isEmpty()) {
            int[] move = queue.poll();
            visited[move[0]][move[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nx = move[0] + moveX[i];
                int ny = move[1] + moveY[i];
                if (nx < 0 || ny < 0|| nx >= N || ny >= N) {
                    continue;
                }
                if (visited[nx][ny] == false && map[nx][ny] > rainHeight) {
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }
}
