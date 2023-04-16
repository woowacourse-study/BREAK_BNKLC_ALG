package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3020Gold5 {
    static int N;
    static int H;
    static int[] ups;
    static int[] downs;
    static int lineCnt;
    static int breakCnt;
    public static void main(String[] args) throws IOException {
        game(new InputStreamReader(System.in));
    }

    public static void game(InputStreamReader isr) throws IOException {
        BufferedReader br = new BufferedReader(isr);

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ups = new int[H+1];
        downs = new int[H+1];
        for (int i = 0; i < N/2; i++) {
            ups[Integer.parseInt(br.readLine())] ++;
            downs[Integer.parseInt(br.readLine())] ++;
        }
        int[] ups_sum = new int[H+1];
        int[] downs_sum = new int[H+1];
        for(int i=1;i<H+1;i++){
            ups_sum[i] = ups_sum[i-1] + ups[i];
            downs_sum[i] = downs_sum[i-1] + downs[i];
        }

        breakCnt = Integer.MAX_VALUE;
        lineCnt = 0;
        int now;
        for (int i = 1; i < H+1; i++) {
            now = ups_sum[H] - ups_sum[i-1] + downs_sum[H] - downs_sum[H-i];
            if(now==breakCnt){
                lineCnt ++;
            }
            if(now<breakCnt){
                lineCnt = 1;
                breakCnt = now;
            }
        }
        System.out.println(breakCnt+" "+lineCnt);
    }
}

