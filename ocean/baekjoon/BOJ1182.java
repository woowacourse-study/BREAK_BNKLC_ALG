package ocean.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1182 {
    private static List<Integer> sequence;
    private static int result = 0;
    private static int N,S,count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sequence = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        count = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int number = Integer.parseInt(st.nextToken());
            sequence.add(number);
        }

        recursive(0,0);

        if(S==0){
            result--;
        }

        System.out.println(result);
    }

    public static void recursive(int count,int total){
        if(count==N){
            if(total==S) {
                result++;
            }
            return;
        }
        recursive(count+1, total + sequence.get(count));
        recursive(count+1, total);
    }
}
