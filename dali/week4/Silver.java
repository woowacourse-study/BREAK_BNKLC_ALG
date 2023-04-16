package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Silver {
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        game(new InputStreamReader(System.in));
    }

    public static void game(InputStreamReader isr) throws IOException {
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result= 0;
        int total = 0;
        int end = 0;
        for (int start = 0; start < N; start++) {
            while(total<M && end<N){
                total+=arr[end];
                end++;
            }
            if(total == M){
                result++;
            }
            total -= arr[start];
        }
        System.out.println(result);
    }
}
