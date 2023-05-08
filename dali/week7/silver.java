package week7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class silver {
    private static int N;
    private static int[][] arr;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/waterricecake/woowahan/algorithm/무제 폴더/week7/silver"));
        game(new InputStreamReader(System.in));
    }

    public static void game(InputStreamReader isr) throws IOException {
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        arr = new int[N][N];
        int now;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                now = Integer.parseInt(st.nextToken());
                arr[i][j] = now;
                max = Math.max(max, now);
            }
        }
        int result = 0;
        int total;
        int[] nxy;
        int nx;
        int ny;
        boolean[][] visited;
        Stack<int[]> stack;
        for (int rain = 0; rain < max; rain++) {
            visited = new boolean[N][N];
            total = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        if (arr[x][y] > rain) {
                            total++;
                            stack = new Stack<>();
                            stack.add(new int[]{x, y});
                            while (!stack.isEmpty()) {
                                nxy = stack.pop();
                                for (int dir = 0; dir < 4; dir++) {
                                    nx = nxy[0] + dx[dir];
                                    ny = nxy[1] + dy[dir];
                                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                                        continue;
                                    }
                                    if (!visited[nx][ny]) {
                                        visited[nx][ny] = true;
                                        if (arr[nx][ny] > rain) {
                                            stack.add(new int[]{nx, ny});
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            result = Math.max(result, total);
        }
        System.out.println(result);
    }

}
