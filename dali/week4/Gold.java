package dali.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold {
    static int N;
    static int S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        game(new InputStreamReader(System.in));
    }

    public static void game(InputStreamReader isr) throws IOException {
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result= 0;
        int min_result = Integer.MAX_VALUE;
        int total = 0;
        int end = 0;
        for (int start = 0; start < N; start++) {
            while(total< S && end<N){
                total+=arr[end];
                result++;
                end++;
            }
            if(total>=S) {
                min_result = Math.min(result, min_result);
            }
            total -= arr[start];
            result--;
        }
        if(min_result == Integer.MAX_VALUE){
            min_result = 0;
        }
        System.out.println(min_result);
    }
}
