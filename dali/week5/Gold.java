import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int M;
    private static int N;
    private static int[][] map;
    private static int[][] countMap;
    private static final int[] mDir = {1,0,-1,0};
    private static final int[] nDir = {0,1,0,-1};
    private static int count;
    public static void main(String[] args) throws IOException {
        game(new InputStreamReader(System.in));
    }

    public static void game(InputStreamReader isr) throws IOException {
        BufferedReader br = new BufferedReader(isr);

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        countMap = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(countMap[i],-1);
        }
        dfs(0,0);
        System.out.println(countMap[0][0]);
    }

    private static int dfs(int m, int n) {
        if (m == M - 1 & n == N - 1) {
            return 1;
        }
        if(countMap[m][n] != -1){
            return countMap[m][n];
        }
        int dM;
        int dN;
        countMap[m][n] = 0;
        for (int i = 0; i < 4; i++) {
            dM = m + mDir[i];
            dN = n + nDir[i];
            if (dM < 0 || dN < 0 || dM == M || dN == N) {
                continue;
            }
            if(map[dM][dN] < map[m][n]){
                countMap[m][n] += dfs(dM,dN);
            }
        }
        return countMap[m][n];
    }
}
