package week7;

import java.io.*;
import java.util.*;

public class gold{
    private static int N;
    private static int M;
    private static int[][] arr;
    private static int result = Integer.MIN_VALUE;
    private static final int[] dx = {1,0,-1,0};
    private static final int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/waterricecake/woowahan/algorithm/무제 폴더/week7/gold.txt"));
        game(new InputStreamReader(System.in));
    }

    public static void game(InputStreamReader isr) throws IOException {
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        setWall(3);
        System.out.println(result);
    }
    private static void setWall(int wall){
        if(wall == 0){
            virus();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0){
                    arr[i][j] = 1;
                    setWall(wall-1);
                    arr[i][j] = 0;
                }
            }
        }
    }
    private static void virus(){
        boolean[][] visited = new boolean[N][M];
        int[][] copyArr = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        int now;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                now = arr[i][j];
                copyArr[i][j] = now;
                if(now == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int[] nxy;
        int nx;
        int ny;
        while(!queue.isEmpty()){
            nxy = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                nx = nxy[0] + dx[dir];
                ny = nxy[1] + dy[dir];
                if(0<=nx && nx<N && 0<=ny && ny<M) {
                    if(copyArr[nx][ny] == 0){
                        copyArr[nx][ny] = 2;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }
        result = Math.max(count(copyArr),result);
    }
    private static int count(int[][] arr){
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
